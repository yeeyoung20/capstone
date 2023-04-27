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

        val back=findViewById<ImageButton>(R.id.back)
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
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //버튼 누르면 분리배출 방법 안내 예시
        tv.setOnClickListener{
            val intent= Intent(this, Category2Tv::class.java)
            startActivity(intent)
        }
        filter.setOnClickListener{
            val intent= Intent(this, Category2Filter::class.java)
            startActivity(intent)
        }
        refrigerator.setOnClickListener{
            val intent= Intent(this, Category2Refrigerator::class.java)
            startActivity(intent)
        }
        laptop.setOnClickListener{
            val intent= Intent(this, Category2Laptop::class.java)
            startActivity(intent)
        }
        laptopbattery.setOnClickListener{
            val intent= Intent(this, Category2Laptopbattery::class.java)
            startActivity(intent)
        }
        mouse.setOnClickListener{
            val intent= Intent(this, Category2Mouse::class.java)
            startActivity(intent)
        }
        multitap.setOnClickListener{
            val intent= Intent(this, Category2Multitap::class.java)
            startActivity(intent)
        }
        monitor.setOnClickListener{
            val intent= Intent(this, Category2Monitor::class.java)
            startActivity(intent)
        }
        auxiliarybattery.setOnClickListener{
            val intent= Intent(this, Category2Auxiliarybattery::class.java)
            startActivity(intent)
        }
        washingmachine.setOnClickListener{
            val intent= Intent(this, Category2Washingmachine::class.java)
            startActivity(intent)
        }
        smallheater.setOnClickListener{
            val intent= Intent(this, Category2Smallheater::class.java)
            startActivity(intent)
        }
        speaker.setOnClickListener{
            val intent= Intent(this, Category2Speaker::class.java)
            startActivity(intent)
        }
        hotwatermat.setOnClickListener{
            val intent= Intent(this, Category2Hotwatermat::class.java)
            startActivity(intent)
        }
        earphone.setOnClickListener{
            val intent= Intent(this, Category2Earphone::class.java)
            startActivity(intent)
        }
        electricrazor.setOnClickListener{
            val intent= Intent(this, Category2Electricrazor::class.java)
            startActivity(intent)
        }
        electricpad.setOnClickListener{
            val intent= Intent(this, Category2Electricpad::class.java)
            startActivity(intent)
        }
        wire.setOnClickListener{
            val intent= Intent(this, Category2Wire::class.java)
            startActivity(intent)
        }
        charger.setOnClickListener{
            val intent= Intent(this, Category2Charger::class.java)
            startActivity(intent)
        }
        computer.setOnClickListener{
            val intent= Intent(this, Category2Computer::class.java)
            startActivity(intent)
        }
        keyboard.setOnClickListener{
            val intent= Intent(this, Category2Keyboard::class.java)
            startActivity(intent)
        }
        tablet.setOnClickListener{
            val intent= Intent(this, Category2Tablet::class.java)
            startActivity(intent)
        }
        inkcartridge.setOnClickListener{
            val intent= Intent(this, Category2Inkcartridge::class.java)
            startActivity(intent)
        }
        printer.setOnClickListener{
            val intent= Intent(this, Category2Printer::class.java)
            startActivity(intent)
        }
        harddisk.setOnClickListener{
            val intent= Intent(this, Category2Harddisk::class.java)
            startActivity(intent)
        }

    }
}
