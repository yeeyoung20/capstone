package com.example.ecoproject_android

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MyInfoChange : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_info_change)

        //수정완료 버튼
        val finishchange = findViewById<Button>(R.id.finishchange)
        val builder = AlertDialog.Builder(this)

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
    }
}