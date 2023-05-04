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
        //버튼 누르면 분리배출 방법 안내 예시
        eggshell.setOnClickListener{
            val intent= Intent(this, Category8Eggshell::class.java)
            startActivity(intent)
        }
        nutshell.setOnClickListener{
            val intent= Intent(this, Category8Nutshell::class.java)
            startActivity(intent)
        }
        chili.setOnClickListener{
            val intent= Intent(this, Category8Chili::class.java)
            startActivity(intent)
        }
        fruitpeel.setOnClickListener{
            val intent= Intent(this, Category8Fruitpeel::class.java)
            startActivity(intent)
        }
        fruitseed.setOnClickListener{
            val intent= Intent(this, Category8Fruitseed::class.java)
            startActivity(intent)
        }
        skintangerine.setOnClickListener{
            val intent= Intent(this, Category8Skintangerine::class.java)
            startActivity(intent)
        }
        animalbones.setOnClickListener{
            val intent= Intent(this, Category8Animalbones::class.java)
            startActivity(intent)
        }
        garlic.setOnClickListener{
            val intent= Intent(this, Category8Garlic::class.java)
            startActivity(intent)
        }
        skinmelon.setOnClickListener{
            val intent= Intent(this, Category8Skinmelon::class.java)
            startActivity(intent)
        }
        bananapeel.setOnClickListener{
            val intent= Intent(this, Category8Bananapeel::class.java)
            startActivity(intent)
        }
        applepeel.setOnClickListener{
            val intent= Intent(this, Category8Applepeel::class.java)
            startActivity(intent)
        }
        skinwatermelon.setOnClickListener{
            val intent= Intent(this, Category8Skinwatermelon::class.java)
            startActivity(intent)
        }
        oil.setOnClickListener{
            val intent= Intent(this, Category8Oil::class.java)
            startActivity(intent)
        }
        avocadopeel.setOnClickListener{
            val intent= Intent(this, Category8Avocadopeel::class.java)
            startActivity(intent)
        }
        medicine.setOnClickListener{
            val intent= Intent(this, Category8Medicine::class.java)
            startActivity(intent)
        }
        onion.setOnClickListener{
            val intent= Intent(this, Category8Onion::class.java)
            startActivity(intent)
        }
        orangepeel.setOnClickListener{
            val intent= Intent(this, Category8Orangepeel::class.java)
            startActivity(intent)
        }
        corner.setOnClickListener{
            val intent= Intent(this, Category8Corner::class.java)
            startActivity(intent)
        }
        jang.setOnClickListener{
            val intent= Intent(this, Category8Jang::class.java)
            startActivity(intent)
        }
        coffeegrounds.setOnClickListener{
            val intent= Intent(this, Category8Coffeegrounds::class.java)
            startActivity(intent)
        }
        coconutshell.setOnClickListener{
            val intent= Intent(this, Category8Coconutshell::class.java)
            startActivity(intent)
        }
        kiwishell.setOnClickListener{
            val intent= Intent(this, Category8Kiwishell::class.java)
            startActivity(intent)
        }
        teabag.setOnClickListener{
            val intent= Intent(this, Category8Teabag::class.java)
            startActivity(intent)
        }
        greenonion.setOnClickListener{
            val intent= Intent(this, Category8Greenonion::class.java)
            startActivity(intent)
        }
        pineapplepeel.setOnClickListener{
            val intent= Intent(this, Category8Pineapplepeel::class.java)
            startActivity(intent)
        }
    }
}
