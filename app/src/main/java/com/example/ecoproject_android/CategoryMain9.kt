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
        back.setOnClickListener{finish()}

        //버튼 누르면 분리배출 방법 안내 예시
        styrofoam.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "스티로폼")
            startActivity(intent)
        }
        gascontainer.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "가스용기")
            startActivity(intent)
        }
        packagingbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "개별 포장 봉지")
            startActivity(intent)
        }
        eggplant.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "계란판")
            startActivity(intent)
        }
        snackbox.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "과자 박스")
            startActivity(intent)
        }
        confectionerybag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "과자 봉지")
            startActivity(intent)
        }
        oilbottle.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "기름병")
            startActivity(intent)
        }
        ramenbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "라면 봉지")
            startActivity(intent)
        }
        sterilizationpack.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "멸균팩")
            startActivity(intent)
        }
        box.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "박스")
            startActivity(intent)
        }
        deliveryplasticcontainer.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "배달 플라스틱 용기")
            startActivity(intent)
        }
        nonwovenbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "부직포 가방")
            startActivity(intent)
        }
        milkpowder.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "분유통")
            startActivity(intent)
        }
        plasticbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "비닐봉투")
            startActivity(intent)
        }
        plasticpackaging.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "비닐포장재")
            startActivity(intent)
        }
        shoppingbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "쇼핑백")
            startActivity(intent)
        }
        alcoholsodabottle.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "술, 탄산음료병")
            startActivity(intent)
        }
        silicon.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "실리콘")
            startActivity(intent)
        }
        icepack.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "아이스팩")
            startActivity(intent)
        }
        aluminumcan.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "알루미늄 캔")
            startActivity(intent)
        }
        aircap.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "에어캡")
            startActivity(intent)
        }
        yogurtcontainer.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "요거트 용기")
            startActivity(intent)
        }
        yogurtbottle.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "요구르트 병")
            startActivity(intent)
        }
        milkpack.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "우유팩")
            startActivity(intent)
        }
        glassbottle.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("data", "유리병")
            startActivity(intent)
        }
    }
}
