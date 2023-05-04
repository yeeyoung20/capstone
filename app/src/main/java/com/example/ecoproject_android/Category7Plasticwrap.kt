package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Category7Plasticwrap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category7_plasticwrap)

        val back=findViewById<ImageButton>(R.id.back)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, CategoryMain7::class.java)
            startActivity(intent)
        }
    }
}