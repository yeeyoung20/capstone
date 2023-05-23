package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main9)

        val back=findViewById<Button>(R.id.back)
        val styrofoam=findViewById<Button>(R.id.styrofoam)
        val gascontainer=findViewById<Button>(R.id.gascontainer)
        val packagingbag=findViewById<Button>(R.id.packagingbag)
        val eggplant=findViewById<Button>(R.id.eggplant)
        val snackbox=findViewById<Button>(R.id.snackbox)
        val confectionerybag=findViewById<Button>(R.id.confectionerybag)
        val oilbottle=findViewById<Button>(R.id.oilbottle)
        val ramenbag=findViewById<Button>(R.id.ramenbag)
        val sterilizationpack=findViewById<Button>(R.id.sterilizationpack)
        val box=findViewById<Button>(R.id.box)
        val deliveryplasticcontainer=findViewById<Button>(R.id.deliveryplasticcontainer)
        val nonwovenbag=findViewById<Button>(R.id.nonwovenbag)
        val milkpowder=findViewById<Button>(R.id.milkpowder)
        val plasticbag=findViewById<Button>(R.id.plasticbag)
        val plasticpackaging=findViewById<Button>(R.id.plasticpackaging)
        val shoppingbag=findViewById<Button>(R.id.shoppingbag)
        val alcoholsodabottle=findViewById<Button>(R.id.alcoholsodabottle)
        val silicon=findViewById<Button>(R.id.silicon)
        val icepack=findViewById<Button>(R.id.icepack)
        val aluminumcan=findViewById<Button>(R.id.aluminumcan)
        val aircap=findViewById<Button>(R.id.aircap)
        val yogurtcontainer=findViewById<Button>(R.id.yogurtcontainer)
        val yogurtbottle=findViewById<Button>(R.id.yogurtbottle)
        val milkpack=findViewById<Button>(R.id.milkpack)
        val glassbottle=findViewById<Button>(R.id.glassbottle)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //버튼 누르면 분리배출 방법 안내 예시
        styrofoam.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("styrofoam", "스티로폼")
            startActivity(intent)
        }
        gascontainer.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("gascontainer", "가스용기")
            startActivity(intent)
        }
        packagingbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("packagingbag", "개별 포장 봉지")
            startActivity(intent)
        }
        eggplant.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("eggplant", "계란판")
            startActivity(intent)
        }
        snackbox.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("snackbox", "과자 박스")
            startActivity(intent)
        }
        confectionerybag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("confectionerybag", "과자 봉지")
            startActivity(intent)
        }
        oilbottle.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("oilbottle", "기름병")
            startActivity(intent)
        }
        ramenbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("ramenbag", "라면 봉지")
            startActivity(intent)
        }
        sterilizationpack.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("sterilizationpack", "멸균팩")
            startActivity(intent)
        }
        box.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("box", "박스")
            startActivity(intent)
        }
        deliveryplasticcontainer.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("deliveryplasticcontainer", "배달 플라스틱 용기")
            startActivity(intent)
        }
        nonwovenbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("nonwovenbag", "부직포 가방")
            startActivity(intent)
        }
        milkpowder.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("milkpowder", "분유통")
            startActivity(intent)
        }
        plasticbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("plasticbag", "비닐봉투")
            startActivity(intent)
        }
        plasticpackaging.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("plasticpackaging", "비닐포장재")
            startActivity(intent)
        }
        shoppingbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("shoppingbag", "쇼핑백")
            startActivity(intent)
        }
        alcoholsodabottle.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("alcoholsodabottle", "술, 탄산음료병")
            startActivity(intent)
        }
        silicon.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("silicon", "실리콘")
            startActivity(intent)
        }
        icepack.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("icepack", "아이스팩")
            startActivity(intent)
        }
        aluminumcan.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("aluminumcan", "알루미늄 캔")
            startActivity(intent)
        }
        aircap.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("aircap", "에어캡")
            startActivity(intent)
        }
        yogurtcontainer.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("yogurtcontainer", "요거트 용기")
            startActivity(intent)
        }
        yogurtbottle.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("yogurtbottle", "요구르트 병")
            startActivity(intent)
        }
        milkpack.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("milkpack", "우유팩")
            startActivity(intent)
        }
        glassbottle.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("glassbottle", "유리병")
            startActivity(intent)
        }
    }
}
