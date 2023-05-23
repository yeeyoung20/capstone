package com.example.ecoproject_android

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class CommunityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_main)

        val write_button = findViewById<Button>(R.id.write_button)
        val back=findViewById<Button>(R.id.back)
        val builder = AlertDialog.Builder(this)
        val listview = findViewById<ListView>(R.id.listview)

        val titleList: ArrayList<String> = ArrayList()

        val seqList: ArrayList<String> = ArrayList()

        val user = Firebase.auth.currentUser

        write_button.setOnClickListener {
            if (user != null) {
                val intent= Intent(this, CommunityWrite::class.java)
                startActivity(intent)
            } else {
                builder.setMessage("로그인 후 이용해주세요!")
                builder.setPositiveButton("확인", DialogInterface.OnClickListener({ dialog, id ->
                    val intent = Intent(this, SignIn::class.java)
                    startActivity(intent)
                }))
                builder.setNegativeButton("취소", DialogInterface.OnClickListener({ dialog, id ->
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }))
                builder.create()
                builder.show()
            }
        }


        //뒤로가기
        back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
