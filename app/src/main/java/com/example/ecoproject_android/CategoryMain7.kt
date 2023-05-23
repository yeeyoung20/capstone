package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CategoryMain7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main7)

        val back=findViewById<Button>(R.id.back)
        val fryingpan=findViewById<Button>(R.id.fryingpan)
        val scissors=findViewById<Button>(R.id.scissors)
        val rubberband=findViewById<Button>(R.id.rubberband)
        val rubberglove=findViewById<Button>(R.id.rubberglove)
        val bowl=findViewById<Button>(R.id.bowl)
        val woodenchopsticks=findViewById<Button>(R.id.woodenchopsticks)
        val skillet=findViewById<Button>(R.id.skillet)
        val cuttingboard=findViewById<Button>(R.id.cuttingboard)
        val coldbag=findViewById<Button>(R.id.coldbag)
        val plasticwrap=findViewById<Button>(R.id.plasticwrap)
        val straw=findViewById<Button>(R.id.straw)
        val breadclip=findViewById<Button>(R.id.breadclip)
        val grill=findViewById<Button>(R.id.grill)
        val utensils=findViewById<Button>(R.id.utensils)
        val kitchenknife=findViewById<Button>(R.id.kitchenknife)
        val cookware=findViewById<Button>(R.id.cookware)
        val cup=findViewById<Button>(R.id.cup)
        val cookingfoil=findViewById<Button>(R.id.cookingfoil)
        val tissue=findViewById<Button>(R.id.tissue)
        val jar=findViewById<Button>(R.id.jar)
        val butanegas=findViewById<Button>(R.id.butanegas)
        val onionnet=findViewById<Button>(R.id.onionnet)


        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //버튼 누르면 분리배출 방법 안내 예시
        fryingpan.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("fryingpan", "후라이팬")
            startActivity(intent)
        }
        scissors.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("scissors", "가위")
            startActivity(intent)
        }
        rubberband.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("rubberband", "고무대야")
            startActivity(intent)
        }
        rubberglove.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("rubberglove", "고무장갑")
            startActivity(intent)
        }
        bowl.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("bowl", "그릇")
            startActivity(intent)
        }
        woodenchopsticks.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("woodenchopsticks", "나무젓가락")
            startActivity(intent)
        }
        skillet.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("skillet", "냄비")
            startActivity(intent)
        }
        cuttingboard.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cuttingboard", "도마")
            startActivity(intent)
        }
        coldbag.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("coldbag", "보냉백")
            startActivity(intent)
        }
        plasticwrap.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("plasticwrap", "비닐랩")
            startActivity(intent)
        }
        straw.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("straw", "빨대")
            startActivity(intent)
        }
        breadclip.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("breadclip", "빵클립")
            startActivity(intent)
        }
        grill.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("grill", "석쇠")
            startActivity(intent)
        }
        utensils.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("utensils", "식사 도구")
            startActivity(intent)
        }
        kitchenknife.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("kitchenknife", "식칼")
            startActivity(intent)
        }
        cookware.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cookware", "조리 기구")
            startActivity(intent)
        }
        cup.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cup", "컵")
            startActivity(intent)
        }
        cookingfoil.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("cookingfoil", "쿠킹 호일")
            startActivity(intent)
        }
        tissue.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("tissue", "티슈, 냅킨")
            startActivity(intent)
        }
        jar.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("jar", "항아리")
            startActivity(intent)
        }
        butanegas.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("butanegas", "휴대용 부탄가스")
            startActivity(intent)
        }
        onionnet.setOnClickListener{
            val intent= Intent(this, CategoryDetail::class.java)
            intent.putExtra("onionnet", "양파망")
            startActivity(intent)
        }
    }
}
