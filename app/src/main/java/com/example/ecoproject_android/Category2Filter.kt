package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Category2Filter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category2_filter)

        val back=findViewById<ImageButton>(R.id.back)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, CategoryMain2::class.java)
            startActivity(intent)
        }
    }
}