package com.example.ecoproject_android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*


class CommunityDetail : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_detail)

        val back = findViewById<Button>(R.id.back)
        val chatting=findViewById<Button>(R.id.chatting)
        val titleTextView = findViewById<TextView>(R.id.title)
        val changeTextView = findViewById<TextView>(R.id.change)
        val contentTextView = findViewById<TextView>(R.id.content)
        val dateTextView = findViewById<TextView>(R.id.date) // 날짜를 표시할 TextView
        val userNickname = findViewById<TextView>(R.id.userNickname)


        val title = intent.getStringExtra("title")
        val change = intent.getStringExtra("change")
        val content = intent.getStringExtra("content")
        val Nickname = intent.getStringExtra("userNickname")
        val date = intent.getStringExtra("date")


        // 추출한 데이터를 TextView에 설정
        titleTextView.text = title
        changeTextView.text = change
        contentTextView.text = content
        userNickname.text = Nickname
        dateTextView.text = date


        back.setOnClickListener { finish() }

        chatting.setOnClickListener{
            val intent= Intent(this, ChattingMain::class.java)
            startActivity(intent)
        }
    }
}
