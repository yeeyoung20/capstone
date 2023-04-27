package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main5)

        val back=findViewById<ImageButton>(R.id.back)
        val paper=findViewById<Button>(R.id.paper)
        val cddvd=findViewById<Button>(R.id.cddvd)
        val videotape=findViewById<Button>(R.id.videotape)
        val stapler=findViewById<Button>(R.id.stapler)
        val magnet=findViewById<Button>(R.id.magnet)
        val book=findViewById<Button>(R.id.book)
        val cassettetape=findViewById<Button>(R.id.cassettetape)
        val cutterknife=findViewById<Button>(R.id.cutterknife)
        val writinginstrument=findViewById<Button>(R.id.writinginstrument)


        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //버튼 누르면 분리배출 방법 안내 예시
        paper.setOnClickListener{
            val intent= Intent(this, Category5Paper::class.java)
            startActivity(intent)
        }
        cddvd.setOnClickListener{
            val intent= Intent(this, Category5Cddvd::class.java)
            startActivity(intent)
        }
        videotape.setOnClickListener{
            val intent= Intent(this, Category5Videotape::class.java)
            startActivity(intent)
        }
        stapler.setOnClickListener{
            val intent= Intent(this, Category5Stapler::class.java)
            startActivity(intent)
        }
        magnet.setOnClickListener{
            val intent= Intent(this, Category5Magnet::class.java)
            startActivity(intent)
        }
        book.setOnClickListener{
            val intent= Intent(this, Category5Book::class.java)
            startActivity(intent)
        }
        cassettetape.setOnClickListener{
            val intent= Intent(this, Category5Cassettetape::class.java)
            startActivity(intent)
        }
        cutterknife.setOnClickListener{
            val intent= Intent(this, Category5Cutterknife::class.java)
            startActivity(intent)
        }
        writinginstrument.setOnClickListener{
            val intent= Intent(this, Category5Writinginstrument::class.java)
            startActivity(intent)
        }

    }
}
