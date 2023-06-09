package com.example.ecoproject_android

import ViewPagerAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3


class MainActivity : AppCompatActivity() {

    private var banner = mutableListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        val search=findViewById<ImageButton>(R.id.searchid)
        val viewpager = findViewById<ViewPager2>(R.id.viewpager)
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)


        val main1_1=findViewById<Button>(R.id.main1_1)
        val main1_2=findViewById<Button>(R.id.main1_2)
        val main1_3=findViewById<Button>(R.id.main1_3)
        val main1_4=findViewById<Button>(R.id.main1_4)
        val main1_5=findViewById<Button>(R.id.main1_5)
        val main1_6=findViewById<Button>(R.id.main1_6)
        val main1_7=findViewById<Button>(R.id.main1_7)
        val main1_8=findViewById<Button>(R.id.main1_8)
        val main1_9=findViewById<Button>(R.id.main1_9)
        val main1_10=findViewById<Button>(R.id.main1_10)
        val main1_11=findViewById<Button>(R.id.main1_11)
        val main2_1=findViewById<Button>(R.id.main2_1)
        val main2_2=findViewById<Button>(R.id.main2_2)
        val main2_3=findViewById<Button>(R.id.main2_3)
        val main2_4=findViewById<Button>(R.id.main2_4)

        postToList()
        viewpager.adapter = ViewPagerAdapter(this,banner)
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        indicator.setViewPager(viewpager)



        //메인화면에서 카테고리 이미지버튼 클릭했을 때 화면전환

        search.setOnClickListener{
            val intent= Intent(this, search_page::class.java)
            startActivity(intent)
        }

        main1_1.setOnClickListener{
            val intent= Intent(this, CategoryMain1::class.java)
            startActivity(intent)
        }
        main1_2.setOnClickListener{
            val intent= Intent(this, CategoryMain2::class.java)
            startActivity(intent)
        }
        main1_3.setOnClickListener{
            val intent= Intent(this, CategoryMain3::class.java)
            startActivity(intent)
        }
        main1_4.setOnClickListener{
            val intent= Intent(this, CategoryMain4::class.java)
            startActivity(intent)
        }
        main1_5.setOnClickListener{
            val intent= Intent(this, CategoryMain5::class.java)
            startActivity(intent)
        }
        main1_6.setOnClickListener{
            val intent= Intent(this, CategoryMain6::class.java)
            startActivity(intent)
        }
        main1_7.setOnClickListener{
            val intent= Intent(this, CategoryMain7::class.java)
            startActivity(intent)
        }
        main1_8.setOnClickListener{
            val intent= Intent(this, CategoryMain8::class.java)
            startActivity(intent)
        }
        main1_9.setOnClickListener{
            val intent= Intent(this, CategoryMain9::class.java)
            startActivity(intent)
        }
        main1_10.setOnClickListener{
            val intent= Intent(this, CategoryMain10::class.java)
            startActivity(intent)
        }
        main1_11.setOnClickListener{
            val intent= Intent(this, CategoryMain11::class.java)
            startActivity(intent)
        }
        main2_1.setOnClickListener {
            val intent = Intent(this, CommunityMain::class.java)
            startActivity(intent)
        }
        main2_2.setOnClickListener {
            val intent = Intent(this, ChattingMain::class.java)
            startActivity(intent)
        }
        main2_3.setOnClickListener {
            val intent = Intent(this, Map::class.java)
            startActivity(intent)
        }
        main2_4.setOnClickListener{
            val intent= Intent(this, MainActivityMorepage::class.java)
            startActivity(intent)
        }

    }

    private fun addToList(bnimag:Int){
        banner.add(bnimag)
    }
    private fun postToList(){
        for(i in 1..5){
            addToList(R.drawable.banner)
        }
    }
}