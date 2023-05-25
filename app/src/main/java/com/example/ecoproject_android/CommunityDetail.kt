package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CommunityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_detail)

        val back=findViewById<Button>(R.id.back)

        //뒤로가기
        back.setOnClickListener{finish()}

        val title=findViewById<TextView>(R.id.title)
        val date=findViewById<TextView>(R.id.date)
        val content=findViewById<TextView>(R.id.content)


    }
}