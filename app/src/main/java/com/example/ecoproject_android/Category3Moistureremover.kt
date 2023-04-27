package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Category3Moistureremover : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category3_moistureremover)

        val back=findViewById<ImageButton>(R.id.back)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, CategoryMain3::class.java)
            startActivity(intent)
        }
    }
}