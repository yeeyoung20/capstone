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

        val back=findViewById<Button>(R.id.back)
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
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("toothpaste", "치약")
            startActivity(intent)
        }
        diatomitemat.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("diatomitemat", "규조토 매트")
            startActivity(intent)
        }
        toiletroll.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("toiletroll", "두루마리 휴지")
            startActivity(intent)
        }
        waterfilter.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("waterfilter", "브리타 정수기 필터")
            startActivity(intent)
        }
        towel.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("towel", "수건")
            startActivity(intent)
        }
        cleaningbrush.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cleaningbrush", "총소 솔")
            startActivity(intent)
        }
        toothbrush.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("toothbrush", "칫솔")
            startActivity(intent)
        }
        pumpcontainer.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("pumpcontainer", "펌프형 용기")
            startActivity(intent)
        }

    }
}
