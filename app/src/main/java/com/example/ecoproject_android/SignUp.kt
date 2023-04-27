package com.example.ecoproject_android

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class SignUp : AppCompatActivity() {
    var DB:DBHelper?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        DB=DBHelper(this)

        //지역 선택 스피너
        val settingzone=findViewById<Spinner>(R.id.settingzone)

        val sData=resources.getStringArray(R.array.zone)
        val adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sData)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        settingzone.adapter=adapter

        val inputnickname = findViewById<TextView>(R.id.inputnickname)
        val inputpassword = findViewById<TextView>(R.id.inputpassword)
        val reinputpassword = findViewById<TextView>(R.id.reinputpassword)
        val signupbutton = findViewById<TextView>(R.id.signupbutton)

        signupbutton.setOnClickListener{
            val user=inputnickname.text.toString()
            val pass=inputpassword.text.toString()
            val repass=reinputpassword.text.toString()
            if(user==""||pass==""||repass=="") Toast.makeText(this, "회원정보를 전부 입력해주세요", Toast.LENGTH_SHORT).show()
            else{
                if(pass==repass){
                    val checkUsername=DB!!.checkUsername(user)
                    if(checkUsername==false){
                        val insert=DB!!.insertData(user, pass)
                        if(insert==true){
                            Toast.makeText(this, "가입되었습니다", Toast.LENGTH_SHORT).show()
                            val intent= Intent(applicationContext, SignIn::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this, "이미 가입된 회원입니다", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}