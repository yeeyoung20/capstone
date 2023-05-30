package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class CommunityWrite : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_write)

        val back=findViewById<Button>(R.id.back)
        val title=findViewById<EditText>(R.id.title)
        val change=findViewById<EditText>(R.id.change)
        val content=findViewById<EditText>(R.id.content)
        val done=findViewById<Button>(R.id.done)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()


        //뒤로가기
        back.setOnClickListener{finish()}

        //글을 작성한 뒤 완료 버튼을 눌렀을 때 내용이 비어있으면 토스트메시지로 입력하라고 안내
        done.setOnClickListener {

            val a = title.text.toString()
            val b = change.text.toString()
            val c = content.text.toString()

            if(a.isEmpty()){
                Toast.makeText(this,"제목을 입력하세요.", Toast.LENGTH_SHORT).show()
            }else if(b.isEmpty()){
                Toast.makeText(this,"교환희망장소를 입력하세요.", Toast.LENGTH_SHORT).show()
            }else if(c.isEmpty()){
                Toast.makeText(this,"내용을 입력하세요.", Toast.LENGTH_SHORT).show()
            }else{
                val user = auth.currentUser
                if (user != null) {
                    val email = user.email

                    val postRef = database.getReference("posts").push()
                    val postId = postRef.key

                    if (postId != null) {
                        val post = mapOf(
                            "email" to email,
                            "title" to a,
                            "change" to b,
                            "content" to c
                        )
                        postRef.setValue(post)
                            .addOnSuccessListener {
                                Toast.makeText(
                                    this,
                                    "게시물이 성공적으로 작성되었습니다.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                finish()
                            }
                            .addOnFailureListener {
                                Toast.makeText(
                                    this,
                                    "게시물 작성에 실패했습니다. 다시 시도해주세요.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                    }
                }
            }
        }
    }
}