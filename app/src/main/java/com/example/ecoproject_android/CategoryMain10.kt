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

        //버튼 누르면 분리배출 방법 안내 예시
        hanger.setOnClickListener{
            val intent= Intent(this, Category10Hanger::class.java)
            startActivity(intent)
        }
        bag.setOnClickListener{
            val intent= Intent(this, Category10Bag::class.java)
            startActivity(intent)
        }
        leggings.setOnClickListener{
            val intent= Intent(this, Category10Leggings::class.java)
            startActivity(intent)
        }
        hat.setOnClickListener{
            val intent= Intent(this, Category10Hat::class.java)
            startActivity(intent)
        }
        underwear.setOnClickListener{
            val intent= Intent(this, Category10Underwear::class.java)
            startActivity(intent)
        }
        stockings.setOnClickListener{
            val intent= Intent(this, Category10Stockings::class.java)
            startActivity(intent)
        }
        shoes.setOnClickListener{
            val intent= Intent(this, Category10Shoes::class.java)
            startActivity(intent)
        }
        glasses.setOnClickListener{
            val intent= Intent(this, Category10Glasses::class.java)
            startActivity(intent)
        }
        socks.setOnClickListener{
            val intent= Intent(this, Category10Socks::class.java)
            startActivity(intent)
        }
        travelbag.setOnClickListener{
            val intent= Intent(this, Category10Travelbag::class.java)
            startActivity(intent)
        }
        clothes.setOnClickListener{
            val intent= Intent(this, Category10Clothes::class.java)
            startActivity(intent)
        }
        wallet.setOnClickListener{
            val intent= Intent(this, Category10Wallet::class.java)
            startActivity(intent)
        }
        hanbok.setOnClickListener{
            val intent= Intent(this, Category10Hanbok::class.java)
            startActivity(intent)
        }
        jewelry.setOnClickListener{
            val intent= Intent(this, Category10Jewelry::class.java)
            startActivity(intent)
        }
    }
}
