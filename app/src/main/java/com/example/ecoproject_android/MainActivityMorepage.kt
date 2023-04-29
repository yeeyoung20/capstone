package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivityMorepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_morepage)

        //val usermore = findViewById<Button>(R.id.usermore)
        val inmypage = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.inmypage)

        //정보수정화면으로 전환
        inmypage.setOnClickListener{
            val intent= Intent(this, MyInfoChange::class.java)
            startActivity(intent)
        }
    }
}