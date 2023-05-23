package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main11)

        val back=findViewById<Button>(R.id.back)
        val receipt=findViewById<Button>(R.id.receipt)
        val rubber=findViewById<Button>(R.id.rubber)
        val brokenglass=findViewById<Button>(R.id.brokenglass)
        val vinylother=findViewById<Button>(R.id.vinylother)
        val creditcard=findViewById<Button>(R.id.creditcard)
        val unacceptableplastic=findViewById<Button>(R.id.unacceptableplastic)
        val leaflet=findViewById<Button>(R.id.leaflet)
        val noncombustiblegarbage=findViewById<Button>(R.id.noncombustiblegarbage)
        val plasticother=findViewById<Button>(R.id.plasticother)
        val mixedpaper=findViewById<Button>(R.id.mixedpaper)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //버튼 누르면 분리배출 방법 안내 예시
        receipt.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("receipt", "영수증")
            startActivity(intent)
        }
        rubber.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("rubber", "고무")
            startActivity(intent)
        }
        brokenglass.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("brokenglass", "깨진 유리")
            startActivity(intent)
        }
        vinylother.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("vinylother", "비닐류 OTHER")
            startActivity(intent)
        }
        creditcard.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("creditcard", "신용카드")
            startActivity(intent)
        }
        unacceptableplastic.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("unacceptableplastic", "재활용 불가 플라스틱")
            startActivity(intent)
        }
        leaflet.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("leaflet", "전단지")
            startActivity(intent)
        }
        noncombustiblegarbage.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("noncombustiblegarbage", "타지 않는 쓰레기")
            startActivity(intent)
        }
        plasticother.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("plasticother", "플라스틱 OTHER")
            startActivity(intent)
        }
        mixedpaper.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("mixedpaper", "혼합종이")
            startActivity(intent)
        }
    }
}
