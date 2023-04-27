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

    }
}
