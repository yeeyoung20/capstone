package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main10)

        val back=findViewById<ImageButton>(R.id.back)
        val hanger=findViewById<Button>(R.id.hanger)
        val bag=findViewById<Button>(R.id.bag)
        val leggings=findViewById<Button>(R.id.leggings)
        val hat=findViewById<Button>(R.id.hat)
        val underwear=findViewById<Button>(R.id.underwear)
        val stockings=findViewById<Button>(R.id.stockings)
        val shoes=findViewById<Button>(R.id.shoes)
        val glasses=findViewById<Button>(R.id.glasses)
        val socks=findViewById<Button>(R.id.socks)
        val travelbag=findViewById<Button>(R.id.travelbag)
        val clothes=findViewById<Button>(R.id.clothes)
        val wallet=findViewById<Button>(R.id.wallet)
        val hanbok=findViewById<Button>(R.id.hanbok)
        val jewelry=findViewById<Button>(R.id.jewelry)


        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
