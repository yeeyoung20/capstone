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
        val led=findViewById<Button>(R.id.led)
        val furniture=findViewById<Button>(R.id.furniture)
        val mirror=findViewById<Button>(R.id.mirror)
        val tree=findViewById<Button>(R.id.tree)
        val ceramic=findViewById<Button>(R.id.ceramic)
        val latex=findViewById<Button>(R.id.latex)
        val matrix=findViewById<Button>(R.id.matrix)
        val cushion=findViewById<Button>(R.id.cushion)
        val pillow=findViewById<Button>(R.id.pillow)
        val sofa=findViewById<Button>(R.id.sofa)
        val candle=findViewById<Button>(R.id.candle)
        val chair=findViewById<Button>(R.id.chair)
        val bedding=findViewById<Button>(R.id.bedding)
        val bulb=findViewById<Button>(R.id.bulb)
        val bed=findViewById<Button>(R.id.bed)
        val cattower=findViewById<Button>(R.id.cattower)
        val curtain=findViewById<Button>(R.id.curtain)
        val paintbucket=findViewById<Button>(R.id.paintbucket)
        val lamp=findViewById<Button>(R.id.lamp)
        val pot=findViewById<Button>(R.id.pot)


        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //버튼 누르면 분리배출 방법 안내 예시
        wallpaper.setOnClickListener{
            val intent= Intent(this, Category1Wallpaper::class.java)
            startActivity(intent)
        }
        led.setOnClickListener{
            val intent= Intent(this, Category1Led::class.java)
            startActivity(intent)
        }
        furniture.setOnClickListener{
            val intent= Intent(this, Category1Furniture::class.java)
            startActivity(intent)
        }
        mirror.setOnClickListener{
            val intent= Intent(this, Category1Mirror::class.java)
            startActivity(intent)
        }
        tree.setOnClickListener{
            val intent= Intent(this, Category1Tree::class.java)
            startActivity(intent)
        }
        ceramic.setOnClickListener{
            val intent= Intent(this, Category1Ceramic::class.java)
            startActivity(intent)
        }
        latex.setOnClickListener{
            val intent= Intent(this, Category1Latex::class.java)
            startActivity(intent)
        }
        matrix.setOnClickListener{
            val intent= Intent(this, Category1Matrix::class.java)
            startActivity(intent)
        }
        cushion.setOnClickListener{
            val intent= Intent(this, Category1Cushion::class.java)
            startActivity(intent)
        }
        pillow.setOnClickListener{
            val intent= Intent(this, Category1Pillow::class.java)
            startActivity(intent)
        }
        sofa.setOnClickListener{
            val intent= Intent(this, Category1Sofa::class.java)
            startActivity(intent)
        }
        candle.setOnClickListener{
            val intent= Intent(this, Category1Candle::class.java)
            startActivity(intent)
        }
        chair.setOnClickListener{
            val intent= Intent(this, Category1Chair::class.java)
            startActivity(intent)
        }
        bedding.setOnClickListener{
            val intent= Intent(this, Category1Bedding::class.java)
            startActivity(intent)
        }
        bulb.setOnClickListener{
            val intent= Intent(this, Category1Bulb::class.java)
            startActivity(intent)
        }
        bed.setOnClickListener{
            val intent= Intent(this, Category1Bed::class.java)
            startActivity(intent)
        }
        cattower.setOnClickListener{
            val intent= Intent(this, Category1Cattower::class.java)
            startActivity(intent)
        }
        curtain.setOnClickListener{
            val intent= Intent(this, Category1Curtain::class.java)
            startActivity(intent)
        }
        paintbucket.setOnClickListener{
            val intent= Intent(this, Category1Paintbucket::class.java)
            startActivity(intent)
        }
        lamp.setOnClickListener{
            val intent= Intent(this, Category1Lamp::class.java)
            startActivity(intent)
        }
        pot.setOnClickListener{
            val intent= Intent(this, Category1Pot::class.java)
            startActivity(intent)
        }

    }
}
