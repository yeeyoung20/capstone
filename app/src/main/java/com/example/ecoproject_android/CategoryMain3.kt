package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main3)

        val back=findViewById<Button>(R.id.back)
        val scrapmetal=findViewById<Button>(R.id.scrapmetal)
        val battery=findViewById<Button>(R.id.battery)
        val golfbag=findViewById<Button>(R.id.golfbag)
        val ball=findViewById<Button>(R.id.ball)
        val racket=findViewById<Button>(R.id.racket)
        val mask=findViewById<Button>(R.id.mask)
        val mosquitorepellent=findViewById<Button>(R.id.mosquitorepellent)
        val wettissue=findViewById<Button>(R.id.wettissue)
        val sanitarypad=findViewById<Button>(R.id.sanitarypad)
        val moistureremover=findViewById<Button>(R.id.moistureremover)
        val plant=findViewById<Button>(R.id.plant)
        val yogamat=findViewById<Button>(R.id.yogamat)
        val umbrella=findViewById<Button>(R.id.umbrella)
        val toy=findViewById<Button>(R.id.toy)
        val condom=findViewById<Button>(R.id.condom)
        val tape=findViewById<Button>(R.id.tape)
        val hotpack=findViewById<Button>(R.id.hotpack)
        val stringinstrument=findViewById<Button>(R.id.stringinstrument)
        val lighter=findViewById<Button>(R.id.lighter)



        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //버튼 누르면 분리배출 방법 안내 예시
        scrapmetal.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("scrapmetal", "고철")
            startActivity(intent)
        }
        battery.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("battery", "건전지")
            startActivity(intent)
        }
        golfbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("golfbag", "골프 가방")
            startActivity(intent)
        }
        ball.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("ball", "공")
            startActivity(intent)
        }
        racket.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("racket", "라켓")
            startActivity(intent)
        }
        mask.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("mask", "마스크")
            startActivity(intent)
        }
        mosquitorepellent.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("mosquitorepellent", "모기향")
            startActivity(intent)
        }
        wettissue.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("wettissue", "물티슈")
            startActivity(intent)
        }
        sanitarypad.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("sanitarypad", "생리대")
            startActivity(intent)
        }
        moistureremover.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("moistureremover", "습기제거제")
            startActivity(intent)
        }
        plant.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("plant", "식물")
            startActivity(intent)
        }
        yogamat.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("yogamat", "요가 매트")
            startActivity(intent)
        }
        umbrella.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("umbrella", "우산")
            startActivity(intent)
        }
        toy.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("toy", "장난감")
            startActivity(intent)
        }
        condom.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("condom", "콘돔")
            startActivity(intent)
        }
        tape.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("tape", "테이프")
            startActivity(intent)
        }
        hotpack.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("hotpack", "핫팩")
            startActivity(intent)
        }
        stringinstrument.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("stringinstrument", "현악기")
            startActivity(intent)
        }
        lighter.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("lighter", "라이터")
            startActivity(intent)
        }

    }
}
