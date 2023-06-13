package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main2)

        val back=findViewById<Button>(R.id.back)
        val tv=findViewById<Button>(R.id.tv)
        val filter=findViewById<Button>(R.id.filter)
        val refrigerator=findViewById<Button>(R.id.refrigerator)
        val laptop=findViewById<Button>(R.id.laptop)
        val laptopbattery=findViewById<Button>(R.id.laptopbattery)
        val mouse=findViewById<Button>(R.id.mouse)
        val multitap=findViewById<Button>(R.id.multitap)
        val monitor=findViewById<Button>(R.id.monitor)
        val auxiliarybattery=findViewById<Button>(R.id.auxiliarybattery)
        val washingmachine=findViewById<Button>(R.id.washingmachine)
        val smallheater=findViewById<Button>(R.id.smallheater)
        val speaker=findViewById<Button>(R.id.speaker)
        val hotwatermat=findViewById<Button>(R.id.hotwatermat)
        val earphone=findViewById<Button>(R.id.earphone)
        val electricrazor=findViewById<Button>(R.id.electricrazor)
        val electricpad=findViewById<Button>(R.id.electricpad)
        val wire=findViewById<Button>(R.id.wire)
        val charger=findViewById<Button>(R.id.charger)
        val computer=findViewById<Button>(R.id.computer)
        val keyboard=findViewById<Button>(R.id.keyboard)
        val tablet=findViewById<Button>(R.id.tablet)
        val inkcartridge=findViewById<Button>(R.id.inkcartridge)
        val printer=findViewById<Button>(R.id.printer)
        val harddisk=findViewById<Button>(R.id.harddisk)


        //뒤로가기
        back.setOnClickListener{finish()}
        //버튼 누르면 분리배출 방법 안내 예시
        tv.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "TV")
            startActivity(intent)
        }
        filter.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "공기청정기 필터")
            startActivity(intent)
        }
        refrigerator.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "냉장고")
            startActivity(intent)
        }
        laptop.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "노트북")
            startActivity(intent)
        }
        laptopbattery.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "노트북 배터리")
            startActivity(intent)
        }
        mouse.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "마우스")
            startActivity(intent)
        }
        multitap.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "멀티탭")
            startActivity(intent)
        }
        monitor.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "모니터")
            startActivity(intent)
        }
        auxiliarybattery.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "보조배터리")
            startActivity(intent)
        }
        washingmachine.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "세탁기")
            startActivity(intent)
        }
        smallheater.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "소형 난방기구")
            startActivity(intent)
        }
        speaker.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "스피커")
            startActivity(intent)
        }
        hotwatermat.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "온수매트")
            startActivity(intent)
        }
        earphone.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "이어폰")
            startActivity(intent)
        }
        electricrazor.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "전기면도기")
            startActivity(intent)
        }
        electricpad.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "전기장판")
            startActivity(intent)
        }
        wire.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "전선")
            startActivity(intent)
        }
        charger.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "충전기, 케이블")
            startActivity(intent)
        }
        computer.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "컴퓨터")
            startActivity(intent)
        }
        keyboard.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "키보드")
            startActivity(intent)
        }
        tablet.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "태블릿")
            startActivity(intent)
        }
        inkcartridge.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "토너, 잉크 카트리지")
            startActivity(intent)
        }
        printer.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "프린터")
            startActivity(intent)
        }
        harddisk.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "하드디스크")
            startActivity(intent)
        }

    }
}
