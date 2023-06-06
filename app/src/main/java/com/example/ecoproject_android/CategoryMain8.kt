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

        val back=findViewById<Button>(R.id.back)
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
        back.setOnClickListener{finish()}
        //버튼 누르면 분리배출 방법 안내 예시
        eggshell.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "달걀 껍질")
            startActivity(intent)
        }
        nutshell.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "견과류 껍질")
            startActivity(intent)
        }
        chili.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "고추")
            startActivity(intent)
        }
        fruitpeel.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "과일 껍질")
            startActivity(intent)
        }
        fruitseed.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "과일 씨")
            startActivity(intent)
        }
        skintangerine.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "귤 껍질")
            startActivity(intent)
        }
        animalbones.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "동물 뼈")
            startActivity(intent)
        }
        garlic.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "마늘")
            startActivity(intent)
        }
        skinmelon.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "멜론 껍질")
            startActivity(intent)
        }
        bananapeel.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "바나나 껍질")
            startActivity(intent)
        }
        applepeel.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "사과 껍질, 심, 씨방")
            startActivity(intent)
        }
        skinwatermelon.setOnClickListener {
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "수박 껍질")
            startActivity(intent)
        }
        oil.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "식용유, 기름")
            startActivity(intent)
        }
        avocadopeel.setOnClickListener {
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "아보카도 껍질, 씨")
            startActivity(intent)
        }
        medicine.setOnClickListener{
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "약, 영양제")
            startActivity(intent)
        }
        onion.setOnClickListener{
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "양파")
            startActivity(intent)
        }
        orangepeel.setOnClickListener{
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "오렌지 껍질")
            startActivity(intent)
        }
        corner.setOnClickListener{
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "옥수수")
            startActivity(intent)
        }
        jang.setOnClickListener{
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "장류")
            startActivity(intent)
        }
        coffeegrounds.setOnClickListener{
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "커피 찌꺼기")
            startActivity(intent)
        }
        coconutshell.setOnClickListener{
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "코코넛 껍질")
            startActivity(intent)
        }
        kiwishell.setOnClickListener{
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "키위 껍질")
            startActivity(intent)
        }
        teabag.setOnClickListener{
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "티백")
            startActivity(intent)
        }
        greenonion.setOnClickListener{
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "파")
            startActivity(intent)
        }
        pineapplepeel.setOnClickListener{
            val intent = Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "파인애플 껍질, 줄기")
            startActivity(intent)
        }
    }
}
