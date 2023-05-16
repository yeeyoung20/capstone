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

        val back=findViewById<Button>(R.id.back)
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
        back.setOnClickListener{finish()}

        //버튼 누르면 분리배출 방법 안내 예시
        hanger.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "옷걸이")
            startActivity(intent)
        }
        bag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "가방")
            startActivity(intent)
        }
        leggings.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "레깅스")
            startActivity(intent)
        }
        hat.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "모자")
            startActivity(intent)
        }
        underwear.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "속옷")
            startActivity(intent)
        }
        stockings.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "스타킹")
            startActivity(intent)
        }
        shoes.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "신발")
            startActivity(intent)
        }
        glasses.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "안경, 선글라스")
            startActivity(intent)
        }
        socks.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "양말")
            startActivity(intent)
        }
        travelbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "여행용 가방")
            startActivity(intent)
        }
        clothes.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "의류")
            startActivity(intent)
        }
        wallet.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "지갑")
            startActivity(intent)
        }
        hanbok.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "한복")
            startActivity(intent)
        }
        jewelry.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("title", "주얼리")
            startActivity(intent)
        }
    }
}
