package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CommunityWrite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_write)

        val back=findViewById<Button>(R.id.back)
        val title=findViewById<EditText>(R.id.title)
        val change=findViewById<EditText>(R.id.change)
        val content=findViewById<EditText>(R.id.content)
        val done=findViewById<Button>(R.id.done)

        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, CommunityMain::class.java)
            startActivity(intent)
        }

        //글을 작성한 뒤 완료 버튼을 눌렀을 때 내용이 비어있으면 토스트메시지로 입력하라고 안내하는..코딩인데 아직 안 됨
        done.setOnClickListener {
            if(title==null){
                Toast.makeText(this,"제목을 입력하세요.", Toast.LENGTH_SHORT).show()
            }else if(change==null){
                Toast.makeText(this,"교환희망장소를 입력하세요.", Toast.LENGTH_SHORT).show()
            }else if(content==null){
                Toast.makeText(this,"내용을 입력하세요.", Toast.LENGTH_SHORT).show()
            }else{
                val intent= Intent(this, CommunityMain::class.java)
                startActivity(intent)
//                val intent = Intent(this, CommunityDetail::class.java)
//                intent.putExtra(title, change, content)
            }
        }





    }
}