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

        //버튼 누르면 분리배출 방법 안내 예시
        styrofoam.setOnClickListener{
            val intent= Intent(this, Category9Styrofoam::class.java)
            startActivity(intent)
        }
        gascontainer.setOnClickListener{
            val intent= Intent(this, Category9Gascontainer::class.java)
            startActivity(intent)
        }
        packagingbag.setOnClickListener{
            val intent= Intent(this, Category9Packagingbag::class.java)
            startActivity(intent)
        }
        eggplant.setOnClickListener{
            val intent= Intent(this, Category9Eggplant::class.java)
            startActivity(intent)
        }
        snackbox.setOnClickListener{
            val intent= Intent(this, Category9Snackbox::class.java)
            startActivity(intent)
        }
        confectionerybag.setOnClickListener{
            val intent= Intent(this, Category9Confectionerybag::class.java)
            startActivity(intent)
        }
        oilbottle.setOnClickListener{
            val intent= Intent(this, Category9Oilbottle::class.java)
            startActivity(intent)
        }
        ramenbag.setOnClickListener{
            val intent= Intent(this, Category9Ramenbag::class.java)
            startActivity(intent)
        }
        sterilizationpack.setOnClickListener{
            val intent= Intent(this, Category9Sterilizationpack::class.java)
            startActivity(intent)
        }
        box.setOnClickListener{
            val intent= Intent(this, Category9Box::class.java)
            startActivity(intent)
        }
        deliveryplasticcontainer.setOnClickListener{
            val intent= Intent(this, Category9Deliveryplasticcontainer::class.java)
            startActivity(intent)
        }
        nonwovenbag.setOnClickListener{
            val intent= Intent(this, Category9Nonwovenbag::class.java)
            startActivity(intent)
        }
        milkpowder.setOnClickListener{
            val intent= Intent(this, Category9Milkpowder::class.java)
            startActivity(intent)
        }
        plasticbag.setOnClickListener{
            val intent= Intent(this, Category9Plasticbag::class.java)
            startActivity(intent)
        }
        plasticpackaging.setOnClickListener{
            val intent= Intent(this, Category9Plasticpackaging::class.java)
            startActivity(intent)
        }
        shoppingbag.setOnClickListener{
            val intent= Intent(this, Category9Shoppingbag::class.java)
            startActivity(intent)
        }
        alcoholsodabottle.setOnClickListener{
            val intent= Intent(this, Category9Alcoholsodabottle::class.java)
            startActivity(intent)
        }
        silicon.setOnClickListener{
            val intent= Intent(this, Category9Silicon::class.java)
            startActivity(intent)
        }
        icepack.setOnClickListener{
            val intent= Intent(this, Category9Icepack::class.java)
            startActivity(intent)
        }
        aluminumcan.setOnClickListener{
            val intent= Intent(this, Category9Aluminumcan::class.java)
            startActivity(intent)
        }
        aircap.setOnClickListener{
            val intent= Intent(this, Category9Aircap::class.java)
            startActivity(intent)
        }
        yogurtcontainer.setOnClickListener{
            val intent= Intent(this, Category9Yogurtcontainer::class.java)
            startActivity(intent)
        }
        yogurtbottle.setOnClickListener{
            val intent= Intent(this, Category9Yogurtbottle::class.java)
            startActivity(intent)
        }
        milkpack.setOnClickListener{
            val intent= Intent(this, Category9Milkpack::class.java)
            startActivity(intent)
        }
        glassbottle.setOnClickListener{
            val intent= Intent(this, Category9Glassbottle::class.java)
            startActivity(intent)
        }
    }
}
