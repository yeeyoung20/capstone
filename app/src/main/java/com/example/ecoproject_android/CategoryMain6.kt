package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main6)

        val back=findViewById<Button>(R.id.back)
        val cosmetics=findViewById<Button>(R.id.cosmetics)
        val perfume=findViewById<Button>(R.id.perfume)
        val cosmeticsstick=findViewById<Button>(R.id.cosmeticsstick)
        val cosmeticstube=findViewById<Button>(R.id.cosmeticstube)
        val cosmeticspumptype=findViewById<Button>(R.id.cosmeticspumptype)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //버튼 누르면 분리배출 방법 안내 예시
        cosmetics.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cosmetics", "화장품")
            startActivity(intent)
        }
        perfume.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("perfume", "향수")
            startActivity(intent)
        }
        cosmeticsstick.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cosmeticsstick", "화장품(스틱)")
            startActivity(intent)
        }
        cosmeticstube.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cosmeticstube", "화장품(튜브)")
            startActivity(intent)
        }
        cosmeticspumptype.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cosmeticspumptype", "화장품(펌프형)")
            startActivity(intent)
        }

    }
}
