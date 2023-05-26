package com.example.ecoproject_android

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class MyInfoChange : AppCompatActivity() {

    private lateinit var firebaseDatabase: FirebaseDatabase

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_info_change)

        //수정완료 버튼
        val finishchange = findViewById<Button>(R.id.finishchange)
        val builder = AlertDialog.Builder(this)
        val logout = findViewById<TextView>(R.id.logout)

        //지역 선택 스피너
        val changezone=findViewById<Spinner>(R.id.changezone)
        val sData=resources.getStringArray(R.array.zone)

        val adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sData)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        changezone.adapter=adapter

        //취소 누르면 뒤로가기
        val goback = findViewById<Button>(R.id.goback)

        goback.setOnClickListener {finish()}

        //수정완료 누르면 다시 한 번 확인하는 다이얼로그 띄우기
        finishchange.setOnClickListener {
            builder.setMessage("저장하시겠습니까?")
            builder.setPositiveButton("확인", DialogInterface.OnClickListener({ dialog, id ->
                val intent = Intent(this, MyInfoChange::class.java)
                Toast.makeText(this, "저장 되었습니다.", Toast.LENGTH_SHORT).show() //외 않되지
                startActivity(intent)
            }))
            builder.setNegativeButton("취소", DialogInterface.OnClickListener({ dialog, id ->
                val intent = Intent(this, MyInfoChange::class.java)
                startActivity(intent)
            }))

            builder.create()
            builder.show()
        }

        val user = Firebase.auth.currentUser

        //로그아웃
        logout.setOnClickListener {
            if (user != null) {
                builder.setMessage("로그아웃 하시겠습니까?")
                builder.setPositiveButton("확인", DialogInterface.OnClickListener({ dialog, id ->
                    val intent = Intent(this, MainActivity::class.java)
                    Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                    FirebaseAuth.getInstance().signOut()
                    startActivity(intent)
                }))
                builder.setNegativeButton("취소", DialogInterface.OnClickListener({ dialog, id ->
                    val intent = Intent(this, MyInfoChange::class.java)
                    startActivity(intent)
                }))
            } else {
                Toast.makeText(this, "로그인을 먼저 하세요", Toast.LENGTH_SHORT).show()
            }
            builder.create()
            builder.show()
        }

        val delete=findViewById<TextView>(R.id.delete)

        delete.setOnClickListener{
            if(user!=null){
                builder.setMessage("탈퇴 하시겠습니까?")
                builder.setPositiveButton("확인", ({ dialog, id ->

                    val email = user.email
                    if (email != null) {
                        deleteUserData(email)
                    }

                    //그냥 데이터 탈퇴 코드(수정할 필요x)
                    user.delete()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this,"탈퇴 완료",Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, MainActivity::class.java)

                                startActivity(intent)

                            }else{
                                Toast.makeText(this,"탈퇴 실패",Toast.LENGTH_SHORT).show()
                            }
                        }
                    startActivity(intent)
                }))
                builder.setNegativeButton("취소", ({ dialog, id ->
                    val intent = Intent(this, MyInfoChange::class.java)
                    startActivity(intent)
                }))
            }else {
                Toast.makeText(this, "로그인을 먼저 하세요", Toast.LENGTH_SHORT).show()
            }
            builder.create()
            builder.show()
        }
    }

    //firebase realtime database 특정 유저 정보만 삭제하기(수정할 필요x)
    private fun deleteUserData(email: String) {
        val databaseReference = FirebaseDatabase.getInstance().getReference("users")
        databaseReference.orderByChild("email").equalTo(email)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (snapshot in dataSnapshot.children) {
                        snapshot.ref.removeValue()
                            .addOnSuccessListener {
                                // 데이터 삭제 성공
                                // TODO: 추가적인 처리 및 UI 업데이트 등 수행
                            }
                            .addOnFailureListener { error ->
                                // 데이터 삭제 실패
                                // TODO: 실패에 대한 처리 수행
                            }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // 쿼리 취소됨
                    // TODO: 에러 처리
                }
            })
    }
}