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
        val jewelry=findViewById<Button>(R.id.mixedpaper)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
