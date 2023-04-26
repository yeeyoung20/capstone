package com.example.ecoproject_android

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MyPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val changeid=findViewById<ImageView>(R.id.changeid)
        val changeprofile=findViewById<ImageView>(R.id.changeprofile)
        val changepwd=findViewById<ImageView>(R.id.changepwd)
        val signout = findViewById<LinearLayout>(R.id.signout)

        //테스트 하는데 오류떠서 주석처리함
        //주석만 빼면 오케이

//        changeid.setOnClickListener{
//            val intent= Intent(this, ChangeId::class.java)
//            startActivity(intent)
//        }
//        changeprofile.setOnClickListener{
//            val intent= Intent(this, ChangeProfile::class.java)
//            startActivity(intent)
//        }
//        changepwd.setOnClickListener{
//            val intent= Intent(this, ChangePwd::class.java)
//            startActivity(intent)
//        }
        val builder = AlertDialog.Builder(this)

//로그아웃 버튼 눌렀을 때 다시 한 번 확인하는 다이얼로그 띄우기
// 확인 누르면 ???? 화면으로, 취소 누르면 마이페이지로 돌아감
        signout.setOnClickListener {
            builder.setMessage("로그아웃 하시겠습니까?")
            builder.setPositiveButton("확인", DialogInterface.OnClickListener({ dialog, id ->
                val intent = Intent(this, MyPage::class.java)
                Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show() //외 않되지
                startActivity(intent)
            }))
            builder.setNegativeButton("취소", DialogInterface.OnClickListener({ dialog, id ->
                val intent = Intent(this, MyPage::class.java)
                startActivity(intent)
            }))

            builder.create()
            builder.show()

        }
    }
}