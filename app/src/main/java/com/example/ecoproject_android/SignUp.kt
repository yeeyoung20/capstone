package com.example.ecoproject_android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class SignUp : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //지역 선택 스피너
        val settingzone=findViewById<Spinner>(R.id.settingzone)

        val sData=resources.getStringArray(R.array.zone)
        val adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sData)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        settingzone.adapter=adapter
    }
}