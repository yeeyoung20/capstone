package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView

class ChattingMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatting_main)

        val back=findViewById<Button>(R.id.back)
        //val listview=findViewById<ListView>(R.id.listview)

        //뒤로가기
        back.setOnClickListener{finish()}
    }
}