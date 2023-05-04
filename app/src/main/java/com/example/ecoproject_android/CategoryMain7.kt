package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main7)

        val back=findViewById<ImageButton>(R.id.back)
        val fryingpan=findViewById<Button>(R.id.fryingpan)
        val scissors=findViewById<Button>(R.id.scissors)
        val rubberband=findViewById<Button>(R.id.rubberband)
        val rubberglove=findViewById<Button>(R.id.rubberglove)
        val bowl=findViewById<Button>(R.id.bowl)
        val woodenchopsticks=findViewById<Button>(R.id.woodenchopsticks)
        val skillet=findViewById<Button>(R.id.skillet)
        val cuttingboard=findViewById<Button>(R.id.cuttingboard)
        val coldbag=findViewById<Button>(R.id.coldbag)
        val plasticwrap=findViewById<Button>(R.id.plasticwrap)
        val straw=findViewById<Button>(R.id.straw)
        val breadclip=findViewById<Button>(R.id.breadclip)
        val grill=findViewById<Button>(R.id.grill)
        val utensils=findViewById<Button>(R.id.utensils)
        val kitchenknife=findViewById<Button>(R.id.kitchenknife)
        val cookware=findViewById<Button>(R.id.cookware)
        val cup=findViewById<Button>(R.id.cup)
        val cookingfoil=findViewById<Button>(R.id.cookingfoil)
        val tissue=findViewById<Button>(R.id.tissue)
        val jar=findViewById<Button>(R.id.jar)
        val butanegas=findViewById<Button>(R.id.butanegas)
        val onionnet=findViewById<Button>(R.id.onionnet)


        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //버튼 누르면 분리배출 방법 안내 예시
        fryingpan.setOnClickListener{
            val intent= Intent(this, Category7Fryingpan::class.java)
            startActivity(intent)
        }
        scissors.setOnClickListener{
            val intent= Intent(this, Category7Scissors::class.java)
            startActivity(intent)
        }
        rubberband.setOnClickListener{
            val intent= Intent(this, Category7Rubberband::class.java)
            startActivity(intent)
        }
        rubberglove.setOnClickListener{
            val intent= Intent(this, Category7Rubberglove::class.java)
            startActivity(intent)
        }
        bowl.setOnClickListener{
            val intent= Intent(this, Category7Bowl::class.java)
            startActivity(intent)
        }
        woodenchopsticks.setOnClickListener{
            val intent= Intent(this, Category7Woodenchopsticks::class.java)
            startActivity(intent)
        }
        skillet.setOnClickListener{
            val intent= Intent(this, Category7Skillet::class.java)
            startActivity(intent)
        }
        cuttingboard.setOnClickListener{
            val intent= Intent(this, Category7Cuttingboard::class.java)
            startActivity(intent)
        }
        coldbag.setOnClickListener{
            val intent= Intent(this, Category7Coldbag::class.java)
            startActivity(intent)
        }
        plasticwrap.setOnClickListener{
            val intent= Intent(this, Category7Plasticwrap::class.java)
            startActivity(intent)
        }
        straw.setOnClickListener{
            val intent= Intent(this, Category7Straw::class.java)
            startActivity(intent)
        }
        breadclip.setOnClickListener{
            val intent= Intent(this, Category7Breadclip::class.java)
            startActivity(intent)
        }
        grill.setOnClickListener{
            val intent= Intent(this, Category7Grill::class.java)
            startActivity(intent)
        }
        utensils.setOnClickListener{
            val intent= Intent(this, Category7Utensils::class.java)
            startActivity(intent)
        }
        kitchenknife.setOnClickListener{
            val intent= Intent(this, Category7Kitchenknife::class.java)
            startActivity(intent)
        }
        cookware.setOnClickListener{
            val intent= Intent(this, Category7Cookware::class.java)
            startActivity(intent)
        }
        cup.setOnClickListener{
            val intent= Intent(this, Category7Cup::class.java)
            startActivity(intent)
        }
        cookingfoil.setOnClickListener{
            val intent= Intent(this, Category7Cookingfoil::class.java)
            startActivity(intent)
        }
        tissue.setOnClickListener{
            val intent= Intent(this, Category7Tissue::class.java)
            startActivity(intent)
        }
        jar.setOnClickListener{
            val intent= Intent(this, Category7Jar::class.java)
            startActivity(intent)
        }
        butanegas.setOnClickListener{
            val intent= Intent(this, Category7Butanegas::class.java)
            startActivity(intent)
        }
        onionnet.setOnClickListener{
            val intent= Intent(this, Category7Onionnet::class.java)
            startActivity(intent)
        }
    }
}
