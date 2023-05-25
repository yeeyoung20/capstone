package com.example.ecoproject_android

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase

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

        //
        firebaseDatabase = FirebaseDatabase.getInstance()

        auth =FirebaseAuth.getInstance()

        signupbutton.setOnClickListener {
            val email = userId.text.toString()
            val password = userPwd.text.toString()
            val passCheck = passCheck.text.toString()
            val userNickname = userNickname.text.toString()
            val zone = settingzone.selectedItem.toString()

            


            if(email.equals("") || password.equals("") || passCheck.equals("")) {
                Toast.makeText(this,"필수 정보를 입력하세요.",Toast.LENGTH_SHORT).show()
            }else{
                if(password >= 6.toString()) {
                    Toast.makeText(this,"비밀번호는 6자리 이상으로 설정하세요.",Toast.LENGTH_SHORT).show()
                }else if(password!=passCheck){
                    Toast.makeText(this,"비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show()
                }else{
                    auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener { task ->
                            if(task.isSuccessful){
                                Toast.makeText(this,"회원가입에 성공했습니다!",Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, SignIn::class.java)
                                startActivity(intent)

                                val databaseReference = firebaseDatabase.getReference("users").push()
                                databaseReference.child("email").setValue(email)
                                databaseReference.child("userNickname").setValue(userNickname)
                                databaseReference.child("zone").setValue(zone)
                            }else{
                                Toast.makeText(this,"이미 존재하는 계정이거나, 회원가입에 실패했습니다.",Toast.LENGTH_SHORT).show()
                            }
                        }
                    auth.run {}
                }
            }
        }
    }

}