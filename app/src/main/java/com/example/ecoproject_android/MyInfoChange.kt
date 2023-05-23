package com.example.ecoproject_android

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MyInfoChange : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_info_change)

        //수정완료 버튼
        val finishchange = findViewById<Button>(R.id.finishchange)
        val builder = AlertDialog.Builder(this)
        val logout = findViewById<TextView>(R.id.logout)

        //지역 선택 스피너
        val changezone=findViewById<Spinner>(R.id.changezone)
        val sData=resources.getStringArray(R.array.zone)

        val adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sData)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        changezone.adapter=adapter

        //취소 누르면 뒤로가기
        val goback = findViewById<Button>(R.id.goback)

        goback.setOnClickListener {
            val intent = Intent(this, MainActivityMorepage::class.java)
            startActivity(intent)
        }

        //수정완료 누르면 다시 한 번 확인하는 다이얼로그 띄우기
        finishchange.setOnClickListener {
            builder.setMessage("저장하시겠습니까?")
            builder.setPositiveButton("확인", DialogInterface.OnClickListener({ dialog, id ->
                val intent = Intent(this, MyInfoChange::class.java)
                Toast.makeText(this, "저장 되었습니다.", Toast.LENGTH_SHORT).show() //외 않되지
                startActivity(intent)
            }))
            builder.setNegativeButton("취소", DialogInterface.OnClickListener({ dialog, id ->
                val intent = Intent(this, MyInfoChange::class.java)
                startActivity(intent)
            }))

            builder.create()
            builder.show()
        }

        val user = Firebase.auth.currentUser

        //로그아웃
        logout.setOnClickListener {
            if (user != null) {
                builder.setMessage("로그아웃 하시겠습니까?")
                builder.setPositiveButton("확인", DialogInterface.OnClickListener({ dialog, id ->
                    val intent = Intent(this, MainActivity::class.java)
                    Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                    FirebaseAuth.getInstance().signOut()
                    startActivity(intent)
                }))
                builder.setNegativeButton("취소", DialogInterface.OnClickListener({ dialog, id ->
                    val intent = Intent(this, MyInfoChange::class.java)
                    startActivity(intent)
                }))
            } else {
                Toast.makeText(this, "로그인을 먼저 하세요", Toast.LENGTH_SHORT).show()
            }
            builder.create()
            builder.show()
        }


        //회원탈퇴 미완성

        val delete=findViewById<TextView>(R.id.delete)

        delete.setOnClickListener{
            if(user!=null){
                builder.setMessage("탈퇴 하시겠습니까?")
                builder.setPositiveButton("확인", DialogInterface.OnClickListener({ dialog, id ->
                    //탈퇴 코드 필요
                    user.delete()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this,"탈퇴 완료",Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(this,"탈퇴 실패",Toast.LENGTH_SHORT).show()
                            }
                        }
                    startActivity(intent)
                }))
                builder.setNegativeButton("취소", DialogInterface.OnClickListener({ dialog, id ->
                    val intent = Intent(this, MyInfoChange::class.java)
                    startActivity(intent)
                }))
            }else {
                Toast.makeText(this, "로그인을 먼저 하세요", Toast.LENGTH_SHORT).show()
            }
            builder.create()
            builder.show()
        }
    }
}