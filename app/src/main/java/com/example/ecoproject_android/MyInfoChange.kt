package com.example.ecoproject_android

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlin.collections.Map

class MyInfoChange : AppCompatActivity() {

    private lateinit var firebaseDatabase: FirebaseDatabase

    private lateinit var originalpwd: EditText
    private lateinit var changepwd: EditText
    private lateinit var changepwdcheck: EditText


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_info_change)

        val userEmail = findViewById<TextView>(R.id.userEmail)
        val userNickname = findViewById<TextView>(R.id.userNickname)
        val changeNickname = findViewById<EditText>(R.id.changeNickname)

        originalpwd = findViewById<EditText>(R.id.originalpwd)
        changepwd = findViewById<EditText>(R.id.changepwd)
        changepwdcheck = findViewById<EditText>(R.id.changepwdcheck)

        firebaseDatabase = FirebaseDatabase.getInstance()

        //수정완료 버튼
        val finishchange = findViewById<Button>(R.id.finishchange)
        val builder = AlertDialog.Builder(this)
        val logout = findViewById<TextView>(R.id.logout)

        //지역 선택 스피너
        val changezone = findViewById<Spinner>(R.id.changezone)
        val sData = resources.getStringArray(R.array.zone)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sData)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        changezone.adapter = adapter

        //취소 누르면 뒤로가기
        val goback = findViewById<Button>(R.id.goback)

        goback.setOnClickListener { finish() }

        val user = Firebase.auth.currentUser

        if (user != null) {
            // Firebase Realtime Database의 레퍼런스를 가져옵니다.
            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val usersRef: DatabaseReference = database.getReference("users")

            userEmail.text = user.email

            // 닉네임을 가져오기 위해 해당 사용자의 데이터를 조회합니다.
            usersRef.orderByChild("email").equalTo(user.email)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        // 해당 사용자의 데이터가 존재하는 경우
                        if (dataSnapshot.exists()) {
                            for (snapshot in dataSnapshot.children) {
                                val userMap: Map<String, String> =
                                    snapshot.getValue() as Map<String, String>
                                val nickname = userMap["userNickname"]
                                val zone = userMap["zone"]
                                userNickname.setText(nickname)
                                changezone.setSelection(sData.indexOf(zone))
                            }
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // 조회 중 에러가 발생한 경우
                        // 에러 처리 로직을 추가하세요.
                    }
                })

        }


        // 수정완료 누르면
        finishchange.setOnClickListener {
            val originalPassword = originalpwd.text.toString()
            val newNickname = changeNickname.text.toString()
            val newPassword = changepwd.text.toString()
            val newPasswordCheck = changepwdcheck.text.toString()

            if (originalPassword.isNotEmpty()) {
                // 현재 비밀번호 확인
                val user = Firebase.auth.currentUser

                if (user != null) {
                    val credential = EmailAuthProvider.getCredential(user.email.toString(), originalPassword)

                    user.reauthenticate(credential)
                        .addOnSuccessListener {
                            // 현재 사용자 인증 성공

                            // 닉네임만 변경
                            if (newNickname.isNotEmpty()) {
                                updateNickname(newNickname)
                                Toast.makeText(this@MyInfoChange, "닉네임이 성공적으로 변경되었습니다.", Toast.LENGTH_SHORT).show()
                            }

                            // 비밀번호만 변경
                            if (newPassword.isNotEmpty() && newPassword == newPasswordCheck) {
                                // 새 비밀번호가 일치하고 비밀번호 변경 필요
                                user.updatePassword(newPassword)
                                    .addOnSuccessListener {
                                        // 비밀번호 변경 후 데이터베이스 업데이트
                                        updatePasswordInDatabase(user.email.toString(), newPassword)
                                        // 비밀번호 변경 성공
                                        Toast.makeText(this@MyInfoChange, "비밀번호가 성공적으로 변경되었습니다.", Toast.LENGTH_SHORT).show()
                                    }
                                    .addOnFailureListener { error ->
                                        // 비밀번호 변경 실패
                                        Toast.makeText(this@MyInfoChange, "비밀번호 변경에 실패했습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
                                    }
                            } else if (newPassword.isNotEmpty() && newPassword != newPasswordCheck) {
                                // 새 비밀번호와 비밀번호 확인이 일치하지 않음
                                Toast.makeText(this@MyInfoChange, "새 비밀번호와 비밀번호 확인이 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                            }
                        }
                        .addOnFailureListener { error ->
                            // 현재 사용자 인증 실패
                            Toast.makeText(this@MyInfoChange, "현재 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                        }
                }
            } else {
                Toast.makeText(this, "현재 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

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

        val delete = findViewById<TextView>(R.id.delete)

        delete.setOnClickListener {
            if (user != null) {
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
                                Toast.makeText(this, "탈퇴 완료", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, MainActivity::class.java)

                                startActivity(intent)

                            } else {
                                Toast.makeText(this, "탈퇴 실패", Toast.LENGTH_SHORT).show()
                            }
                        }
                    startActivity(intent)
                }))
                builder.setNegativeButton("취소", ({ dialog, id ->
                    val intent = Intent(this, MyInfoChange::class.java)
                    startActivity(intent)
                }))
            } else {
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

    private fun updateNickname(newNickname: String) {
        val user = Firebase.auth.currentUser

        if (user != null) {
            val databaseReference = firebaseDatabase.getReference("users")
            databaseReference.orderByChild("email").equalTo(user.email)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (snapshot in dataSnapshot.children) {
                            snapshot.ref.child("userNickname").setValue(newNickname)
                                .addOnSuccessListener {
                                    // 닉네임 변경 성공
                                    Toast.makeText(this@MyInfoChange, "닉네임이 성공적으로 변경되었습니다.", Toast.LENGTH_SHORT).show()
                                }
                                .addOnFailureListener { error ->
                                    // 닉네임 변경 실패
                                    Toast.makeText(this@MyInfoChange, "닉네임 변경에 실패했습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
                                }
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Query canceled or failed
                        Toast.makeText(this@MyInfoChange, "닉네임 변경에 실패했습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    // 데이터베이스에 비밀번호를 업데이트하는 함수
    private fun updatePasswordInDatabase(email: String, newPassword: String) {
        val databaseReference = firebaseDatabase.getReference("users")
        databaseReference.orderByChild("email").equalTo(email)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (snapshot in dataSnapshot.children) {
                        snapshot.ref.child("userPwd").setValue(newPassword)
                            .addOnSuccessListener {
                                // 비밀번호 업데이트 성공
                                Toast.makeText(this@MyInfoChange, "비밀번호가 성공적으로 변경되었습니다.", Toast.LENGTH_SHORT).show()
                            }
                            .addOnFailureListener { error ->
                                // 비밀번호 업데이트 실패
                                Toast.makeText(this@MyInfoChange, "비밀번호 변경에 실패했습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
                            }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // 쿼리 취소 시
                    Toast.makeText(this@MyInfoChange, "비밀번호 변경에 실패했습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
                }
            })
    }

}