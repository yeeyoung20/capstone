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
import java.net.URL


class CommunityMain : AppCompatActivity() {
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var listView: ListView
    private lateinit var database: FirebaseDatabase
    private lateinit var postsRef: DatabaseReference
    private lateinit var valueEventListener: ValueEventListener
    private var postList: MutableList<Post> = mutableListOf() // 초기화 변경

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_main)

        postList = mutableListOf()

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
            adapter.notifyDataSetChanged() // 추가
        }

        // 뒤로가기
        back.setOnClickListener { finish() }

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if(user!=null){
                val selectedItem = adapter.getItem(position)
                val post = postList[position] // 선택된 게시물 객체

                // CommunityDetail 액티비티로 전환하고 선택된 게시물의 정보를 전달
                val intent = Intent(this, CommunityDetail::class.java)
                intent.putExtra("title", post.title)
                intent.putExtra("change", post.change)
                intent.putExtra("content", post.content)
                intent.putExtra("userNickname", post.userNickname)
                intent.putExtra("date", post.date)
                intent.putExtra("imageUrl", post.imageUrl)
                intent.putExtra("postId", post.postId)
                intent.putExtra("email", post.email)
                startActivity(intent)
            }else{
                builder.setMessage("로그인 후 이용해주세요!")
                    .setPositiveButton("확인") { dialog, id ->
                        val intent = Intent(this, SignIn::class.java)
                        startActivity(intent)
                    }
                    .setNegativeButton("취소") { dialog, id ->

                    }
                    .create()
                    .show()
            }

        }

        valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                postList.clear()
                adapter.clear()

                for (postSnapshot in dataSnapshot.children) {
                    val post = postSnapshot.getValue(Post::class.java)
                    post?.let {
                        postList.add(it)
                        val data = "제목: ${it.title}\n 교환희망장소: ${it.change}\n 작성자: ${it.userNickname}"
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
    val email: String? = null,
    val userNickname: String? = null,
    val title: String? = null,
    val change: String? = null,
    val content: String? = null,
    val date: String? = null,
    val postId: String? = null,
    val imageUrl: String? = null // imageUrl 필드 추가
)
