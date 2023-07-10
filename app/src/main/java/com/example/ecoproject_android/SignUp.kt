package com.example.ecoproject_android

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

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

        // Firebase Database 초기화
        firebaseDatabase = FirebaseDatabase.getInstance()
        auth =FirebaseAuth.getInstance()

        signupbutton.setOnClickListener {
            val email = userId.text.toString()
            val password = userPwd.text.toString()
            val passCheck = passCheck.text.toString()
            val userNickname = userNickname.text.toString()
            val zone = settingzone.selectedItem.toString()

            if(email.isEmpty() || password.isEmpty() || passCheck.isEmpty() || userNickname.isEmpty()) {
                Toast.makeText(this, "필수 정보를 입력하세요.", Toast.LENGTH_SHORT).show()
            } else if (password.length < 6) {
                Toast.makeText(this, "비밀번호는 6자리 이상으로 설정하세요.", Toast.LENGTH_SHORT).show()
            } else if (password != passCheck) {
                Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            } else {
                // 닉네임 중복 여부 확인
                val usersRef = firebaseDatabase.getReference("users")
                usersRef.orderByChild("userNickname").equalTo(userNickname)
                    .addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                // 이미 닉네임이 사용 중인 경우
                                Toast.makeText(this@SignUp, "이미 사용 중인 닉네임입니다.", Toast.LENGTH_SHORT).show()
                            } else {
                                // 중복된 닉네임이 없는 경우, 회원 가입 진행
                                auth.createUserWithEmailAndPassword(email, password)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            Toast.makeText(this@SignUp, "회원가입에 성공했습니다!", Toast.LENGTH_SHORT).show()
                                            val intent = Intent(this@SignUp, SignIn::class.java)
                                            startActivity(intent)

                                            val userUid = auth.currentUser!!.uid
                                            // Firebase Realtime Database에 사용자 데이터 삽입
                                            val databaseReference = firebaseDatabase.getReference("users").child(userUid)

                                            val user = hashMapOf<String, String>()
                                            user["userUid"]=userUid
                                            user["email"] = email
                                            user["userPwd"] = password
                                            user["userNickname"] = userNickname
                                            user["zone"] = zone
                                            databaseReference.setValue(user)
                                        } else {
                                            Toast.makeText(this@SignUp, "이미 존재하는 계정이거나, 회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            // 취소 시 동작할 로직 추가
                        }
                    })
            }
        }
    }

}