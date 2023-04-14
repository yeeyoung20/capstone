package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signup = findViewById<TextView>(R.id.signup)

        signup.setOnClickListener{
            val intent= Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}