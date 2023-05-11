package com.example.ecoproject_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TabHost

class mypost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypost)

        val tabHost: TabHost = findViewById<TabHost>(R.id.tabhost)
        tabHost.setup()

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