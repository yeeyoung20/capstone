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

        val back=findViewById<ImageButton>(R.id.back)
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
            val intent= Intent(this, Category3Scrapmetal::class.java)
            startActivity(intent)
        }
        battery.setOnClickListener{
            val intent= Intent(this, Category3Battery::class.java)
            startActivity(intent)
        }
        golfbag.setOnClickListener{
            val intent= Intent(this, Category3Golfbag::class.java)
            startActivity(intent)
        }
        ball.setOnClickListener{
            val intent= Intent(this, Category3Ball::class.java)
            startActivity(intent)
        }
        racket.setOnClickListener{
            val intent= Intent(this, Category3Racket::class.java)
            startActivity(intent)
        }
        mask.setOnClickListener{
            val intent= Intent(this, Category3Mask::class.java)
            startActivity(intent)
        }
        mosquitorepellent.setOnClickListener{
            val intent= Intent(this, Category3Mosquitorepellent::class.java)
            startActivity(intent)
        }
        wettissue.setOnClickListener{
            val intent= Intent(this, Category3Wettissue::class.java)
            startActivity(intent)
        }
        sanitarypad.setOnClickListener{
            val intent= Intent(this, Category3Sanitarypad::class.java)
            startActivity(intent)
        }
        moistureremover.setOnClickListener{
            val intent= Intent(this, Category3Moistureremover::class.java)
            startActivity(intent)
        }
        plant.setOnClickListener{
            val intent= Intent(this, Category3Plant::class.java)
            startActivity(intent)
        }
        yogamat.setOnClickListener{
            val intent= Intent(this, Category3Yogamat::class.java)
            startActivity(intent)
        }
        umbrella.setOnClickListener{
            val intent= Intent(this, Category3Umbrella::class.java)
            startActivity(intent)
        }
        toy.setOnClickListener{
            val intent= Intent(this, Category3Toy::class.java)
            startActivity(intent)
        }
        condom.setOnClickListener{
            val intent= Intent(this, Category3Condom::class.java)
            startActivity(intent)
        }
        tape.setOnClickListener{
            val intent= Intent(this, Category3Tape::class.java)
            startActivity(intent)
        }
        hotpack.setOnClickListener{
            val intent= Intent(this, Category3Hotpack::class.java)
            startActivity(intent)
        }
        stringinstrument.setOnClickListener{
            val intent= Intent(this, Category3Stringinstrument::class.java)
            startActivity(intent)
        }
        lighter.setOnClickListener{
            val intent= Intent(this, Category3Lighter::class.java)
            startActivity(intent)
        }

    }
}
