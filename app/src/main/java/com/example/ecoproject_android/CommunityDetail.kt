package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CommunityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_detail)

        val back=findViewById<Button>(R.id.back)

        //뒤로가기
        back.setOnClickListener{finish()}

        val titleTextView = findViewById<TextView>(R.id.title)
        val changeTextView = findViewById<TextView>(R.id.change)
        val dateTextView = findViewById<TextView>(R.id.date)
        val nicknameTextView = findViewById<TextView>(R.id.nickname)
        val contentTextView = findViewById<TextView>(R.id.content)

        // Retrieve the data from the intent
        val title = intent.getStringExtra("title")
        val change = intent.getStringExtra("change")
        val content = intent.getStringExtra("content")

        // Set the data to the corresponding TextViews
        titleTextView.text = title
        changeTextView.text = change
        contentTextView.text = content

    }
}