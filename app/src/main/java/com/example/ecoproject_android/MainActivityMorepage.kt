package com.example.ecoproject_android

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.collections.Map

class MainActivityMorepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_more_page)




        //val usermore = findViewById<Button>(R.id.usermore)
        val inmypage = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.inmypage)
        val myanabadabtn = findViewById<Button>(R.id.myanabadabtn)
        val map = findViewById<Button>(R.id.map)
        val loginlogout = findViewById<Button>(R.id.loginlogout)
        val back=findViewById<LinearLayout>(R.id.back)

        back.setOnClickListener{finish()}


        myanabadabtn.setOnClickListener{
            val intent= Intent(this, mypost::class.java)
            startActivity(intent)
        }

        map.setOnClickListener {
            val intent = Intent(this, Map::class.java)
            startActivity(intent)
        }

        //로그인 돼있으면 '로그아웃하기'로 텍스트 변경/기능 구현
        //로그아웃 돼있으면 '로그인하기'로 텍스트 변경/기능 구현
        val user = Firebase.auth.currentUser
        val builder = AlertDialog.Builder(this)

        if (user != null) {
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