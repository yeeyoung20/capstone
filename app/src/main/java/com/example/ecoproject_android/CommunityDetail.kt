package com.example.ecoproject_android

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlin.collections.Map

class CommunityDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_detail)

        val back = findViewById<Button>(R.id.back)
        val chatting = findViewById<Button>(R.id.chatting)
        val delete = findViewById<Button>(R.id.delete)

        val titleTextView = findViewById<TextView>(R.id.title)
        val changeTextView = findViewById<TextView>(R.id.change)
        val contentTextView = findViewById<TextView>(R.id.content)
        val dateTextView = findViewById<TextView>(R.id.date)
        val userNickname = findViewById<TextView>(R.id.userNickname)
        val userimg = findViewById<ImageView>(R.id.userimg)

        val img = findViewById<ImageView>(R.id.img)

        val title = intent.getStringExtra("title")
        val change = intent.getStringExtra("change")
        val content = intent.getStringExtra("content")
        val nickname = intent.getStringExtra("userNickname")
        val date = intent.getStringExtra("date")
        val imageUrl = intent.getStringExtra("imageUrl")
        val email = intent.getStringExtra("email")

        // 추출한 데이터를 TextView에 설정
        titleTextView.text = title
        changeTextView.text = change
        contentTextView.text = content
        userNickname.text = nickname
        dateTextView.text = date

        // 이미지 출력
        if (imageUrl != null) {
            Glide.with(this)
                .load(imageUrl)
                .into(img)
        }

        back.setOnClickListener { finish() }

        // 게시물 삭제 버튼 보이게
        val user = Firebase.auth.currentUser

        if (user != null) {
            val nowUserEmail = user.email

            if (nowUserEmail == email) {
                delete.visibility = View.VISIBLE
            }

        }

        // 프로필 이미지 출력
        val usersRef = FirebaseDatabase.getInstance().reference.child("users")
        usersRef.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    val profileimg = snapshot.child("profileimg").getValue(String::class.java)
                    if (!profileimg.isNullOrEmpty()) {
                        Glide.with(this@CommunityDetail)
                            .load(profileimg)
                            .into(userimg)
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // 프로필 이미지 로드 실패 시 처리할 로직을 작성하세요.
            }
        })


        // 게시물 삭제
        delete.setOnClickListener {
            if (user != null) {
                val nowUserEmail = user.email

                if (nowUserEmail == email) {
                    val postId = intent.getStringExtra("postId")
                    val database = FirebaseDatabase.getInstance()
                    val postRef = database.getReference("posts").child(postId!!)

                    val builder = AlertDialog.Builder(this)
                    builder.setMessage("게시물을 삭제하시겠습니까?")
                    builder.setPositiveButton("확인") { dialog, id ->
                        postRef.removeValue()
                            .addOnSuccessListener {
                                // 게시물 삭제 성공 시 처리할 로직을 작성하세요.
                                Toast.makeText(this@CommunityDetail, "게시물이 삭제되었습니다.", Toast.LENGTH_SHORT).show()

                                // 이미지 삭제
                                if (imageUrl != null) {
                                    val storageRef = Firebase.storage.reference
                                    val imageRef = storageRef.child("images").child("$postId")

                                    imageRef.delete()
                                        .addOnSuccessListener {
                                            // 이미지 삭제 성공 시 처리할 로직을 작성하세요.
                                        }
                                        .addOnFailureListener {
                                            // 이미지 삭제 실패 시 처리할 로직을 작성하세요.
                                            Toast.makeText(this@CommunityDetail, "이미지 삭제에 실패했습니다.", Toast.LENGTH_SHORT).show()
                                        }
                                }

                                finish() // 삭제 후 현재 액티비티 종료
                            }
                            .addOnFailureListener {
                                // 게시물 삭제 실패 시 처리할 로직을 작성하세요.
                                Toast.makeText(this@CommunityDetail, "게시물 삭제에 실패했습니다.", Toast.LENGTH_SHORT).show()
                            }
                    }
                    builder.setNegativeButton("취소") { dialog, id ->
                        // 취소 버튼을 누른 경우 아무 작업도 수행하지 않음
                    }
                    builder.create().show()
                } else {
                    // 게시물 삭제 권한이 없는 경우에 대한 처리
                    Toast.makeText(this@CommunityDetail, "게시물을 삭제할 권한이 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        chatting.setOnClickListener {
            val intent = Intent(this, ChattingMain::class.java)
            startActivity(intent)
        }
    }
}
