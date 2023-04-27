package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main8)

        val back=findViewById<ImageButton>(R.id.back)
        val eggshell=findViewById<Button>(R.id.eggshell)
        val nutshell=findViewById<Button>(R.id.nutshell)
        val chili=findViewById<Button>(R.id.chili)
        val fruitpeel=findViewById<Button>(R.id.fruitpeel)
        val fruitseed=findViewById<Button>(R.id.fruitseed)
        val skintangerine=findViewById<Button>(R.id.skintangerine)
        val animalbones=findViewById<Button>(R.id.animalbones)
        val garlic=findViewById<Button>(R.id.garlic)
        val skinmelon=findViewById<Button>(R.id.skinmelon)
        val bananapeel=findViewById<Button>(R.id.bananapeel)
        val applepeel=findViewById<Button>(R.id.applepeel)
        val skinwatermelon=findViewById<Button>(R.id.skinwatermelon)
        val oil=findViewById<Button>(R.id.oil)
        val avocadopeel=findViewById<Button>(R.id.avocadopeel)
        val medicine=findViewById<Button>(R.id.medicine)
        val onion=findViewById<Button>(R.id.onion)
        val orangepeel=findViewById<Button>(R.id.orangepeel)
        val corner=findViewById<Button>(R.id.corner)
        val jang=findViewById<Button>(R.id.jang)
        val coffeegrounds=findViewById<Button>(R.id.coffeegrounds)
        val coconutshell=findViewById<Button>(R.id.coconutshell)
        val kiwishell=findViewById<Button>(R.id.kiwishell)
        val teabag=findViewById<Button>(R.id.teabag)
        val greenonion=findViewById<Button>(R.id.greenonion)
        val pineapplepeel=findViewById<Button>(R.id.pineapplepeel)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
