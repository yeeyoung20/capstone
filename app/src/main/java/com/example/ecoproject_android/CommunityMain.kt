package com.example.ecoproject_android

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class CommunityMain : AppCompatActivity() {
    var DB:DBHelper?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_main)
        DB=DBHelper(this)

        val write_button = findViewById<Button>(R.id.write_button)
        val back=findViewById<ImageButton>(R.id.back)
        val builder = AlertDialog.Builder(this)


        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        write_button.setOnClickListener {

            //로그인 돼있으면 글쓰기 화면으로 전환
//            if(){
//                val intent=Intent(this, CommunityWrite::class.java)
//                startActivity(intent)
//            }


            //커뮤니티 기본 화면에서 글쓰기 버튼 눌렀을 때 로그인 하라는 다이얼로그 띄우기
            // 확인 누르면 로그인 화면으로, 취소 누르면 메인으로 돌아감
            builder.setMessage("로그인 후 이용해주세요!")
            builder.setPositiveButton("확인", DialogInterface.OnClickListener({ dialog, id ->
                val intent = Intent(this, SignIn::class.java)
                startActivity(intent)
            }))
            builder.setNegativeButton("취소", DialogInterface.OnClickListener({ dialog, id ->
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }))

            builder.create()
            builder.show()

        }
    }
}