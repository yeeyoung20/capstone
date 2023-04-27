package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignIn : AppCompatActivity() {
    var DB:DBHelper?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        DB=DBHelper(this)

        val signup = findViewById<TextView>(R.id.signup)
        val loginButton = findViewById<Button>(R.id.loginbutton)
        val nickname = findViewById<EditText>(R.id.nickname)
        val password = findViewById<EditText>(R.id.password)

        loginButton.setOnClickListener{
            val user=nickname!!.text.toString()
            val pass=password!!.text.toString()
            if(user==""|| pass=="") Toast.makeText(
                this, "회원정보를 전부 입력해주세요", Toast.LENGTH_SHORT
            ).show() else{
                val checkUserpass=DB!!.checkUserpass(user, pass)
                if(checkUserpass==true){
                    Toast.makeText(this, "로그인 되었습니다", Toast.LENGTH_SHORT).show()
                    val intent=Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "회원정보가 존재하지 않습니다", Toast.LENGTH_SHORT).show()
                }
            }
        }
        signup.setOnClickListener{
            val intent= Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}