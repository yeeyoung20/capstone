package com.example.ecoproject_android

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main1)
        val back=findViewById<ImageButton>(R.id.back)
        val wallpaper=findViewById<Button>(R.id.wallpaper)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //벽지 누르면 분리배출 방법 안내 예시
        wallpaper.setOnClickListener{
            val intent= Intent(this, CategoryEx1::class.java)
            startActivity(intent)
        }

    }
}
