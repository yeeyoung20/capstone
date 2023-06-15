package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlin.collections.Map

class MainActivityMorepage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_more_page)

        //val usermore = findViewById<Button>(R.id.usermore)
        val inmypage = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.inmypage)
        val mypostbtn = findViewById<Button>(R.id.mypostbtn)
        val map = findViewById<Button>(R.id.map)
        val loginlogout = findViewById<Button>(R.id.loginlogout)
        val back=findViewById<Button>(R.id.back)
        val usernameTextView = findViewById<TextView>(R.id.username)

        back.setOnClickListener{finish()}


        mypostbtn.setOnClickListener{
            val intent= Intent(this, mypost::class.java)
            startActivity(intent)
        }

        map.setOnClickListener {
            val activityName = "com.example.ecoproject_android.Map"
            val activityClass = Class.forName(activityName)
            val intent = Intent(this, activityClass)
            startActivity(intent)

        }
        //로그인 돼있으면 '로그아웃하기'로 텍스트 변경/기능 구현
        //로그아웃 돼있으면 '로그인하기'로 텍스트 변경/기능 구현
        val user = Firebase.auth.currentUser
        val builder = AlertDialog.Builder(this)

        if (user != null) {

            // Firebase Realtime Database의 레퍼런스를 가져옵니다.
            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val usersRef: DatabaseReference = database.getReference("users")

            // 데이터를 가져오기 위해 해당 사용자의 데이터를 조회합니다.
            usersRef.orderByChild("email").equalTo(user.email).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // 해당 사용자의 데이터가 존재하는 경우
                    if (dataSnapshot.exists()) {
                        for (snapshot in dataSnapshot.children) {
                            val userMap: Map<String, String> = snapshot.getValue() as Map<String, String>

                            // 닉네임 가져오기
                            val nickname = userMap["userNickname"]
                            usernameTextView.text = nickname

                            // 이미지 파일이 있으면 가져와서 출력
                            val userprofileimg = userMap["profileimg"]
                            if (userprofileimg != null) {
                                val userimg = findViewById<ImageView>(R.id.userimg)
                                Glide.with(this@MainActivityMorepage)
                                    .load(userprofileimg)
                                    .into(userimg)
                            }

                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // 조회 중 에러가 발생한 경우
                    // 에러 처리 로직을 추가하세요.
                }
            })

            //로그아웃
            loginlogout.setText("로그아웃 하기")
            loginlogout.setOnClickListener {
                builder.setMessage("로그아웃 하시겠습니까?")
                builder.setPositiveButton("확인", ({ dialog, id ->
                    val intent = Intent(this, MainActivity::class.java)
                    FirebaseAuth.getInstance().signOut()
                    Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }))
                builder.setNegativeButton("취소", ({ dialog, id ->
                    val intent = Intent(this, MainActivityMorepage::class.java)
                    startActivity(intent)
                }))
                builder.create()
                builder.show()
            }

            //정보수정화면으로 전환
            inmypage.setOnClickListener{
                val intent= Intent(this, MyInfoChange::class.java)
                startActivity(intent)
            }
        } else {
            loginlogout.setText("로그인하기")
            loginlogout.setOnClickListener {
                val intent= Intent(this, SignIn::class.java)
                startActivity(intent)
            }

            //정보수정화면으로 전환 못 하게 하기
            inmypage.setOnClickListener{
                builder.setMessage("로그인 후 이용해주세요!")
                builder.setPositiveButton("확인", ({ dialog, id ->
                    val intent = Intent(this, SignIn::class.java)
                    startActivity(intent)
                }))
                builder.setNegativeButton("취소", ({ dialog, id ->
                    val intent = Intent(this, MainActivityMorepage::class.java)
                    startActivity(intent)
                }))
                builder.create()
                builder.show()
            }


        }
    }
}