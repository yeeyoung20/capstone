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

        val back=findViewById<Button>(R.id.back)
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
        back.setOnClickListener{finish()}
        //버튼 누르면 분리배출 방법 안내 예시
        wallpaper.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "벽지")
            startActivity(intent)
        }
        led.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "LED")
            startActivity(intent)
        }
        furniture.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "가구")
            startActivity(intent)
        }
        mirror.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "거울")
            startActivity(intent)
        }
        tree.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "나무")
            startActivity(intent)
        }
        ceramic.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "도자기")
            startActivity(intent)
        }
        latex.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "라텍스")
            startActivity(intent)
        }
        matrix.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "매트리스")
            startActivity(intent)
        }
        cushion.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "방석")
            startActivity(intent)
        }
        pillow.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "베개")
            startActivity(intent)
        }
        sofa.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "소파")
            startActivity(intent)
        }
        candle.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "양초")
            startActivity(intent)
        }
        chair.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "의자")
            startActivity(intent)
        }
        bedding.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "이불")
            startActivity(intent)
        }
        bulb.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "전구(백열등)")
            startActivity(intent)
        }
        bed.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "침대")
            startActivity(intent)
        }
        cattower.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "캣타워")
            startActivity(intent)
        }
        curtain.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "커튼")
            startActivity(intent)
        }
        paintbucket.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "페인트통")
            startActivity(intent)
        }
        lamp.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "형광등")
            startActivity(intent)
        }
        pot.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "화분")
            startActivity(intent)
        }

    }
}
