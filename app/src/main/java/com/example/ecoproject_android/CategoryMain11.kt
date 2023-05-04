package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main11)

        val back=findViewById<ImageButton>(R.id.back)
        val receipt=findViewById<Button>(R.id.receipt)
        val rubber=findViewById<Button>(R.id.rubber)
        val brokenglass=findViewById<Button>(R.id.brokenglass)
        val vinylother=findViewById<Button>(R.id.vinylother)
        val creditcard=findViewById<Button>(R.id.creditcard)
        val unacceptableplastic=findViewById<Button>(R.id.unacceptableplastic)
        val leaflet=findViewById<Button>(R.id.leaflet)
        val noncombustiblegarbage=findViewById<Button>(R.id.noncombustiblegarbage)
        val plasticother=findViewById<Button>(R.id.plasticother)
        val mixedpaper=findViewById<Button>(R.id.mixedpaper)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //버튼 누르면 분리배출 방법 안내 예시
        receipt.setOnClickListener{
            val intent= Intent(this, Category11Receipt::class.java)
            startActivity(intent)
        }
        rubber.setOnClickListener{
            val intent= Intent(this, Category11Rubber::class.java)
            startActivity(intent)
        }
        brokenglass.setOnClickListener{
            val intent= Intent(this, Category11Brokenglass::class.java)
            startActivity(intent)
        }
        vinylother.setOnClickListener{
            val intent= Intent(this, Category11Vinylother::class.java)
            startActivity(intent)
        }
        creditcard.setOnClickListener{
            val intent= Intent(this, Category11Creditcard::class.java)
            startActivity(intent)
        }
        unacceptableplastic.setOnClickListener{
            val intent= Intent(this, Category11Unacceptableplastic::class.java)
            startActivity(intent)
        }
        leaflet.setOnClickListener{
            val intent= Intent(this, Category11Leaflet::class.java)
            startActivity(intent)
        }
        noncombustiblegarbage.setOnClickListener{
            val intent= Intent(this, Category11Noncombustiblegarbage::class.java)
            startActivity(intent)
        }
        plasticother.setOnClickListener{
            val intent= Intent(this, Category11Plasticother::class.java)
            startActivity(intent)
        }
        mixedpaper.setOnClickListener{
            val intent= Intent(this, Category11Mixedpaper::class.java)
            startActivity(intent)
        }
    }
}
