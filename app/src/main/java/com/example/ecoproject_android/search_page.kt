package com.example.ecoproject_android

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class search_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_page)

        val finishBtn = findViewById<Button>(R.id.cancelbtn)

        finishBtn.setOnClickListener { finish()  }

    }
}