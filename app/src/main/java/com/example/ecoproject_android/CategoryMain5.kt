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

        val back=findViewById<Button>(R.id.back)
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
        back.setOnClickListener{finish()}
        //버튼 누르면 분리배출 방법 안내 예시
        paper.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("paper", "일반 종이")
            startActivity(intent)
        }
        cddvd.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cddvd", "CD, DVD")
            startActivity(intent)
        }
        videotape.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("videotape", "비디오 테이프")
            startActivity(intent)
        }
        stapler.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("stapler", "스테이플러, 심")
            startActivity(intent)
        }
        magnet.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("magnet", "자석")
            startActivity(intent)
        }
        book.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("book", "책, 노트, 잡지")
            startActivity(intent)
        }
        cassettetape.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cassettetape", "카세트 테이프")
            startActivity(intent)
        }
        cutterknife.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cutterknife", "커터칼")
            startActivity(intent)
        }
        writinginstrument.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("writinginstrument", "필기구")
            startActivity(intent)
        }

    }
}
