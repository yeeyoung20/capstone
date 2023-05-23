package com.example.ecoproject_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val userId = findViewById<EditText>(R.id.userId)
        val userPwd = findViewById<EditText>(R.id.userPwd)
        val passCheck = findViewById<EditText>(R.id.passCheck)
        val userNickname = findViewById<EditText>(R.id.userNickname)

        //지역 선택 스피너
        val settingzone=findViewById<Spinner>(R.id.settingzone)
        val sData=resources.getStringArray(R.array.zone)
        val adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sData)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        settingzone.adapter=adapter

        val signupbutton = findViewById<Button>(R.id.signupbutton)

        auth =FirebaseAuth.getInstance()
        signupbutton.setOnClickListener {
            val email = userId.text.toString()
            val password = userPwd.text.toString()
            val passCheck = passCheck.text.toString()
            val userNickname = userNickname.text.toString()

            if(password!=passCheck){
                Toast.makeText(this,"비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(this,"회원가입에 성공했습니다!",Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, SignIn::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,"이미 존재하는 계정이거나, 회원가입에 실패했습니다.",Toast.LENGTH_SHORT).show()
                        }
                    }
                auth.run {  }
            }
        }

    }


}