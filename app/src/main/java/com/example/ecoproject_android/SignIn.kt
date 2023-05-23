package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        lateinit var auth : FirebaseAuth

        val userId = findViewById<EditText>(R.id.userId)
        val password = findViewById<EditText>(R.id.password)
        val loginbutton = findViewById<Button>(R.id.loginbutton)
        val signup = findViewById<TextView>(R.id.signup)

        auth = FirebaseAuth.getInstance()
        loginbutton.setOnClickListener {
            val email = userId.text.toString()
            val password = password.text.toString()

            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"로그인에 성공했습니다!",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"로그인에 실패했습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
            auth.run {  }
        }

        signup.setOnClickListener{
            val intent= Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}