package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main4)

        val back=findViewById<ImageButton>(R.id.back)
        val toothpaste=findViewById<Button>(R.id.toothpaste)
        val diatomitemat=findViewById<Button>(R.id.diatomitemat)
        val toiletroll=findViewById<Button>(R.id.toiletroll)
        val waterfilter=findViewById<Button>(R.id.waterfilter)
        val towel=findViewById<Button>(R.id.towel)
        val cleaningbrush=findViewById<Button>(R.id.cleaningbrush)
        val toothbrush=findViewById<Button>(R.id.toothbrush)
        val pumpcontainer=findViewById<Button>(R.id.pumpcontainer)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //버튼 누르면 분리배출 방법 안내 예시
        toothpaste.setOnClickListener{
            val intent= Intent(this, Category4Toothpaste::class.java)
            startActivity(intent)
        }
        diatomitemat.setOnClickListener{
            val intent= Intent(this, Category4Diatomitemat::class.java)
            startActivity(intent)
        }
        toiletroll.setOnClickListener{
            val intent= Intent(this, Category4Toiletroll::class.java)
            startActivity(intent)
        }
        waterfilter.setOnClickListener{
            val intent= Intent(this, Category4Waterfilter::class.java)
            startActivity(intent)
        }
        towel.setOnClickListener{
            val intent= Intent(this, Category4Towel::class.java)
            startActivity(intent)
        }
        cleaningbrush.setOnClickListener{
            val intent= Intent(this, Category4Cleaningbrush::class.java)
            startActivity(intent)
        }
        toothbrush.setOnClickListener{
            val intent= Intent(this, Category4Toothbrush::class.java)
            startActivity(intent)
        }
        pumpcontainer.setOnClickListener{
            val intent= Intent(this, Category4Pumpcontainer::class.java)
            startActivity(intent)
        }

    }
}
