package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class mypost : AppCompatActivity() {

    private lateinit var adapter: PostAdapter
    private lateinit var listView: ListView
    private lateinit var database: FirebaseDatabase
    private lateinit var postsRef: DatabaseReference
    private lateinit var valueEventListener: ValueEventListener
    private var postList: MutableList<Post> = mutableListOf() // 초기화 변경

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypost)

        val tabHost: TabHost = findViewById<TabHost>(R.id.tabhost)
        tabHost.setup()

        val back=findViewById<Button>(R.id.back)
        val writepost=findViewById<Button>(R.id.writepost)

        postList = mutableListOf()
        val builder = AlertDialog.Builder(this)
        listView = findViewById(R.id.listview)

        adapter = PostAdapter(this, R.layout.activity_list_item_layout, postList)
        listView.adapter = adapter


        database = FirebaseDatabase.getInstance()
        postsRef = database.getReference("posts")


        //뒤로가기
        back.setOnClickListener{finish()}

        writepost.setOnClickListener{
            val intent= Intent(this, CommunityWrite::class.java)
            startActivity(intent)
        }


        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val user = Firebase.auth.currentUser

            if (user != null) {
                val post = postList[position] // 선택된 게시물 객체

                // 현재 접속한 사용자의 이메일과 게시물 작성자의 이메일을 비교하여 동일한 경우에만 게시물 표시
                if (user.email == post.email) {
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
                } else {
                    // 다른 사용자의 게시물인 경우에 대한 처리
                    Toast.makeText(this, "권한이 없습니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                // 로그인하지 않은 사용자인 경우에 대한 처리
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

                val user = Firebase.auth.currentUser
                if (user != null) {
                    for (postSnapshot in dataSnapshot.children) {
                        val post = postSnapshot.getValue(Post::class.java)
                        post?.let {
                            // 현재 접속한 사용자의 이메일과 게시물 작성자의 이메일을 비교하여 동일한 경우에만 postList에 추가
                            if (user.email == it.email) {
                                postList.add(it)
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
                // ...
            }
        }

        val myposttab = tabHost.newTabSpec("myposttab")
        myposttab.setIndicator("내가 쓴 글")
        myposttab.setContent(R.id.mypost)
        tabHost.addTab(myposttab)

        val mylikeposttab = tabHost.newTabSpec("myposttab")
        mylikeposttab.setIndicator("내가 쓴 글")
        mylikeposttab.setContent(R.id.mylike)
        tabHost.addTab(mylikeposttab)
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