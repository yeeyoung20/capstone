package com.example.ecoproject_android

import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageException
import com.google.firebase.storage.StorageReference
import kotlin.collections.Map


class MyInfoChange : AppCompatActivity() {

    private lateinit var firebaseDatabase: FirebaseDatabase

    private lateinit var originalpwd: EditText
    private lateinit var changepwd: EditText
    private lateinit var changepwdcheck: EditText


    // 이미지 관련 선언
    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }
    private var imageUri: Uri? = null

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_info_change)

        val userEmail = findViewById<TextView>(R.id.userEmail)
        val userNickname = findViewById<TextView>(R.id.userNickname)
        val changeNickname = findViewById<EditText>(R.id.changeNickname)
        val changeimg = findViewById<ImageButton>(R.id.changeimg)
        val imgdel = findViewById<Button>(R.id.imgdel)

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

            // 데이터를 가져오기 위해 해당 사용자의 데이터를 조회합니다.
            usersRef.orderByChild("email").equalTo(user.email)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        // 해당 사용자의 데이터가 존재하는 경우
                        if (dataSnapshot.exists()) {
                            for (snapshot in dataSnapshot.children) {
                                val userMap: Map<String, String> = snapshot.getValue() as Map<String, String>

                                // 닉네임 가져오기
                                val nickname = userMap["userNickname"]
                                userNickname.setText(nickname)

                                // 지역 가져오기
                                val zone = userMap["zone"]
                                changezone.setSelection(sData.indexOf(zone))

                                // 이미지 파일이 있으면 가져와서 출력
                                val userprofileimg = userMap["profileimg"]
                                if (userprofileimg != null) {
                                    val userimg = findViewById<ImageView>(R.id.userimg)
                                    Glide.with(this@MyInfoChange)
                                        .load(userprofileimg)
                                        .into(userimg)
                                }
                            }
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // 조회 중 에러가 발생한 경우
                        // 에러 처리 로직을 추가하세요.
                    }
                })

        }


        // 프로필 이미지 변경 버튼
        changeimg.setOnClickListener {// 갤러리에서 사진 선택
            openGallery()
        }

        // 프로필 이미지 삭제
        imgdel.setOnClickListener{
            deleteProfileImage()
        }

        // 수정완료 누르면
        finishchange.setOnClickListener {
            val originalPassword = originalpwd.text.toString()
            val newNickname = changeNickname.text.toString()
            val newPassword = changepwd.text.toString()
            val newPasswordCheck = changepwdcheck.text.toString()
            val newZone = changezone.selectedItem.toString()

            if (originalPassword.isNotEmpty()) {
                // 현재 비밀번호 확인
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

                            // 데이터베이스에서 지역 정보 가져오기
                            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
                            val userRef: DatabaseReference = database.getReference("users")
                            userRef.orderByChild("email").equalTo(user.email)
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                                        // 해당 사용자의 데이터가 존재하는 경우
                                        if (dataSnapshot.exists()) {
                                            for (snapshot in dataSnapshot.children) {
                                                val userMap: Map<String, String> =
                                                    snapshot.getValue() as Map<String, String>
                                                val zone = userMap["zone"]

                                                // 지역만 변경
                                                if (newZone != zone) {
                                                    updateZone(newZone)
                                                }
                                            }
                                        }
                                    }

                                    override fun onCancelled(error: DatabaseError) {
                                        // 데이터베이스 조회 실패
                                        Toast.makeText(this@MyInfoChange, "데이터베이스 조회에 실패했습니다.", Toast.LENGTH_SHORT).show()
                                    }
                                })

                            // 프로필 이미지 변경
                            if (imageUri != null) {
                                saveProfile()
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

    // 데이터베이스 닉네임 변경 함수
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

    // 데이터베이스 비밀번호 변경 함수
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

    // 데이터베이스 지역 변경 함수
    private fun updateZone(newZone: String) {
        val user = Firebase.auth.currentUser

        if (user != null) {
            val databaseReference = firebaseDatabase.getReference("users")
            databaseReference.orderByChild("email").equalTo(user.email)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (snapshot in dataSnapshot.children) {
                            val userZone = snapshot.child("zone").getValue(String::class.java)
                            if (userZone != newZone) {
                                snapshot.ref.child("zone").setValue(newZone)
                                    .addOnSuccessListener {
                                        // 지역 변경 성공
                                        Toast.makeText(this@MyInfoChange, "지역이 성공적으로 변경되었습니다.", Toast.LENGTH_SHORT).show()
                                    }
                                    .addOnFailureListener { error ->
                                        // 지역 변경 실패
                                        Toast.makeText(this@MyInfoChange, "지역 변경에 실패했습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
                                    }
                            } else {
                                // 새로운 지역이 선택되지 않았거나, 선택한 지역이 원래 지역과 같은 경우
                                Toast.makeText(this@MyInfoChange, "지역이 변경되지 않았습니다.", Toast.LENGTH_SHORT).show()
                            }
                            // 새로운 지역이 선택되지 않았거나, 선택한 지역이 원래 지역과 같은 경우에도 종료
                            return
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // 쿼리 취소 시
                        Toast.makeText(this@MyInfoChange, "지역 변경에 실패했습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }




    // 갤러리 사용 함수
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    // 이미지 출력
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            imageUri = data.data

            // 선택한 이미지를 ImageView에 설정
            if (imageUri != null) {
                val userimg = findViewById<ImageView>(R.id.userimg)
                userimg.setImageURI(imageUri)
            }

        }
    }

    // 이미지 데이터베이스 삽입
    private fun saveProfile() {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
            if (userId != null) {
                val storageRef = FirebaseStorage.getInstance().reference.child("profile_images").child(userId)

            // 이미지를 스토리지에 업로드
            storageRef.putFile(imageUri!!)
                .addOnSuccessListener { taskSnapshot ->
                    // 업로드된 이미지의 다운로드 URL을 가져옴
                    taskSnapshot.storage.downloadUrl
                        .addOnSuccessListener { downloadUri ->
                            val imageUrl = downloadUri.toString()

                                // 유저 데이터베이스에 이미지 URL 저장
                                val user = Firebase.auth.currentUser
                                val userEmail = findViewById<TextView>(R.id.userEmail)

                                if (user != null) {
                                    // Firebase Realtime Database의 레퍼런스를 가져옵니다.
                                    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
                                val usersRef: DatabaseReference = database.getReference("users")

                                userEmail.text = user.email

                                // 이메일을 통해 사용자 찾기
                                usersRef.orderByChild("email").equalTo(user.email)
                                    .addListenerForSingleValueEvent(object : ValueEventListener {
                                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                                            if (dataSnapshot.exists()) {
                                                // 사용자를 찾았을 경우
                                                for (userSnapshot in dataSnapshot.children) {
                                                    val userKey = userSnapshot.key
                                                    val userData = userSnapshot.value as HashMap<String, Any>?

                                                    // 기존 데이터에 추가 데이터 삽입
                                                    userData?.let {
                                                        it["profileimg"] = imageUrl

                                                        // 데이터 업데이트
                                                        usersRef.child(userKey!!).setValue(it)
                                                            .addOnSuccessListener {
                                                                // 데이터 삽입 성공 시 동작할 코드 작성
                                                                Toast.makeText(this@MyInfoChange, "프로필 이미지 변경 성공.", Toast.LENGTH_SHORT).show()
                                                            }
                                                            .addOnFailureListener { e ->
                                                                // 데이터 삽입 실패 시 동작할 코드 작성
                                                                Toast.makeText(this@MyInfoChange, "프로필 이미지 변경 실패.", Toast.LENGTH_SHORT).show()
                                                            }
                                                    }
                                                }
                                            } else {
                                                // 사용자를 찾지 못한 경우
                                                Toast.makeText(this@MyInfoChange, "사용자를 찾지 못했습니다.", Toast.LENGTH_SHORT).show()
                                            }
                                        }

                                        override fun onCancelled(databaseError: DatabaseError) {
                                            // 조회 취소 또는 실패 시 동작할 코드 작성
                                        }
                                    })
                                }
                        }
                        .addOnFailureListener { exception ->
                            // 이미지 다운로드 URL 가져오기 실패

                        }
                }
                .addOnFailureListener { exception ->
                    // 이미지 업로드 실패
                }
        }
    }


    // 프로필 사진 삭제
    private fun deleteProfileImage() {
        val user = FirebaseAuth.getInstance().currentUser
        val userEmail = findViewById<TextView>(R.id.userEmail)

        if (user != null) {

            val database = FirebaseDatabase.getInstance()
            val usersRef = database.getReference("users")
            val storage = FirebaseStorage.getInstance()
            val storageRef = storage.reference

            val userId = FirebaseAuth.getInstance().currentUser?.uid

            userEmail.text = user.email

            usersRef.orderByChild("email").equalTo(user.email)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (userSnapshot in dataSnapshot.children) {
                                val userKey = userSnapshot.key
                                val userData = userSnapshot.value as HashMap<String, Any>?

                                // 프로필 이미지 데이터 삭제
                                userData?.let {
                                    it.remove("profileimg")

                                    // 데이터 업데이트
                                    usersRef.child(userKey!!).setValue(it)
                                        .addOnSuccessListener {
                                            // 데이터 삭제 성공 시 동작할 코드 작성
                                            Toast.makeText(this@MyInfoChange, "프로필 이미지 삭제 성공.", Toast.LENGTH_SHORT).show()

                                            // 스토리지 이미지 삭제
                                            val profileImgRef: StorageReference = storageRef.child("profile_images/$userId")
                                            profileImgRef.delete()
                                                .addOnSuccessListener {
                                                    // 스토리지 이미지 삭제 성공 시 동작할 코드 작성
                                                    Toast.makeText(this@MyInfoChange, "스토리지 이미지 삭제 성공.", Toast.LENGTH_SHORT).show()
                                                }
                                                .addOnFailureListener { exception ->
                                                    // 스토리지 이미지 삭제 실패 시 동작할 코드 작성
                                                    val errorCode = (exception as StorageException).errorCode
                                                    Toast.makeText(this@MyInfoChange, "스토리지 이미지 삭제 실패. 오류 코드: $errorCode", Toast.LENGTH_SHORT).show()
                                                }
                                        }
                                        .addOnFailureListener { e ->
                                            // 데이터 삭제 실패 시 동작할 코드 작성
                                            Toast.makeText(this@MyInfoChange, "프로필 이미지 삭제 실패.", Toast.LENGTH_SHORT).show()
                                        }
                                }
                            }
                        } else {
                            // 사용자를 찾지 못한 경우
                            Toast.makeText(this@MyInfoChange, "사용자를 찾지 못했습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // 조회 취소 또는 실패 시 동작할 코드 작성
                    }
                })
        }
    }



}