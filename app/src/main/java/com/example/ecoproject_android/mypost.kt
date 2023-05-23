package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TabHost

class mypost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypost)

        val tabHost: TabHost = findViewById<TabHost>(R.id.tabhost)
        tabHost.setup()

        val back=findViewById<Button>(R.id.back)
        val writepost=findViewById<Button>(R.id.writepost)


        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        writepost.setOnClickListener{
            val intent= Intent(this, CommunityWrite::class.java)
            startActivity(intent)
        }

        val myposttab = tabHost.newTabSpec("myposttab")
        myposttab.setIndicator("내가 쓴 글")
        myposttab.setContent(R.id.mypost)
        tabHost.addTab(myposttab)

        val mylikeposttab = tabHost.newTabSpec("myposttab")
        mylikeposttab.setIndicator("내가 쓴 글")
        mylikeposttab.setContent(R.id.mylike)
        tabHost.addTab(mylikeposttab)
    }
}