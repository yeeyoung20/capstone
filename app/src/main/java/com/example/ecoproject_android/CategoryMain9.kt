package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main9)

        val back=findViewById<ImageButton>(R.id.back)
        val styrofoam=findViewById<Button>(R.id.styrofoam)
        val gascontainer=findViewById<Button>(R.id.gascontainer)
        val packagingbag=findViewById<Button>(R.id.packagingbag)
        val eggplant=findViewById<Button>(R.id.eggplant)
        val snackbox=findViewById<Button>(R.id.snackbox)
        val confectionerybag=findViewById<Button>(R.id.confectionerybag)
        val oilbottle=findViewById<Button>(R.id.oilbottle)
        val ramenbag=findViewById<Button>(R.id.ramenbag)
        val sterilizationpack=findViewById<Button>(R.id.sterilizationpack)
        val box=findViewById<Button>(R.id.box)
        val deliveryplasticcontainer=findViewById<Button>(R.id.deliveryplasticcontainer)
        val nonwovenbag=findViewById<Button>(R.id.nonwovenbag)
        val milkpowder=findViewById<Button>(R.id.milkpowder)
        val plasticbag=findViewById<Button>(R.id.plasticbag)
        val plasticpackaging=findViewById<Button>(R.id.plasticpackaging)
        val shoppingbag=findViewById<Button>(R.id.shoppingbag)
        val alcoholsodabottle=findViewById<Button>(R.id.alcoholsodabottle)
        val silicon=findViewById<Button>(R.id.silicon)
        val icepack=findViewById<Button>(R.id.icepack)
        val aluminumcan=findViewById<Button>(R.id.aluminumcan)
        val aircap=findViewById<Button>(R.id.aircap)
        val yogurtcontainer=findViewById<Button>(R.id.yogurtcontainer)
        val yogurtbottle=findViewById<Button>(R.id.yogurtbottle)
        val milkpack=findViewById<Button>(R.id.milkpack)
        val glassbottle=findViewById<Button>(R.id.glassbottle)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
