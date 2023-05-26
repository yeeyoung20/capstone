package com.example.ecoproject_android

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase


class CommunityMain : AppCompatActivity() {
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var listView: ListView
    private lateinit var database: FirebaseDatabase
    private lateinit var postsRef: DatabaseReference
    private lateinit var valueEventListener: ValueEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_main)

        val write_button = findViewById<Button>(R.id.write_button)
        val back = findViewById<Button>(R.id.back)
        val builder = AlertDialog.Builder(this)
        listView = findViewById(R.id.listview)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        listView.adapter = adapter

        database = FirebaseDatabase.getInstance()
        postsRef = database.getReference("posts")

        val user = FirebaseAuth.getInstance().currentUser

        write_button.setOnClickListener {
            if (user != null) {
                val intent = Intent(this, CommunityWrite::class.java)
                startActivity(intent)
            } else {
                builder.setMessage("로그인 후 이용해주세요!")
                    .setPositiveButton("확인") { dialog, id ->
                        val intent = Intent(this, SignIn::class.java)
                        startActivity(intent)
                    }
                    .setNegativeButton("취소") { dialog, id ->
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    .create()
                    .show()
            }
        }

        // 뒤로가기
        back.setOnClickListener { finish() }

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = adapter.getItem(position)
            // Handle item click event
            // ...
        }

        valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                adapter.clear()

                for (postSnapshot in dataSnapshot.children) {
                    val post = postSnapshot.getValue(Post::class.java)
                    post?.let {
                        val data = "제목: ${it.title}\n교환희망장소: ${it.change}\n내용: ${it.content}"
                        adapter.add(data)
                    }
                }

                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
                // ...
            }
        }
    }

    override fun onStart() {
        super.onStart()
        postsRef.addValueEventListener(valueEventListener)
    }

    override fun onStop() {
        super.onStop()
        postsRef.removeEventListener(valueEventListener)
    }
}

data class Post(
    val userId: String? = null,
    val title: String? = null,
    val change: String? = null,
    val content: String? = null
)