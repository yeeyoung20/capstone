package com.example.ecoproject_android

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.Map

class CommunityWrite : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    private val REQUEST_IMAGE_PICK = 1
    private lateinit var imagesRef: StorageReference // 이미지 업로드를 위한 Firebase Storage 레퍼런스
    private var imageUri: Uri? = null // 선택한 이미지의 URI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_write)

        val back = findViewById<Button>(R.id.back)
        val title = findViewById<EditText>(R.id.title)
        val change = findViewById<EditText>(R.id.change)
        val content = findViewById<EditText>(R.id.content)
        val done = findViewById<Button>(R.id.done)
        val userNickname = findViewById<TextView>(R.id.userNickname)
        val image = findViewById<Button>(R.id.image)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        // 뒤로가기
        back.setOnClickListener { finish() }

        val user = auth.currentUser

        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val usersRef: DatabaseReference = database.getReference("users")

        if (user != null) {
            val email = user.email

            // 닉네임을 가져오기 위해 해당 사용자의 데이터를 조회합니다.
            usersRef.orderByChild("email").equalTo(user.email).addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // 해당 사용자의 데이터가 존재하는 경우
                    if (dataSnapshot.exists()) {
                        for (snapshot in dataSnapshot.children) {
                            val userMap: Map<String, String> = snapshot.getValue() as Map<String, String>
                            val nickname = userMap["userNickname"]
                            userNickname.text = nickname
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // 조회 중 에러가 발생한 경우
                    // 에러 처리 로직을 추가하세요.
                }
            })

            // Firebase Storage의 레퍼런스 생성
            val storageRef = FirebaseStorage.getInstance().reference
            imagesRef = storageRef.child("images")

            // 이미지 업로드 버튼
            image.setOnClickListener {
                // 갤러리에서 이미지 선택을 위한 암시적 Intent 생성
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type = "image/*"

                // 이미지 선택을 위한 액티비티 실행
                startActivityForResult(Intent.createChooser(intent, "Select Image"), REQUEST_IMAGE_PICK)
            }

            // 글을 작성한 뒤 완료 버튼을 눌렀을 때 내용이 비어있으면 토스트메시지로 입력하라고 안내
            done.setOnClickListener {

                val a = title.text.toString()
                val b = change.text.toString()
                val c = content.text.toString()
                val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

                if (a.isEmpty()) {
                    Toast.makeText(this, "제목을 입력하세요.", Toast.LENGTH_SHORT).show()
                } else if (b.isEmpty()) {
                    Toast.makeText(this, "교환희망장소를 입력하세요.", Toast.LENGTH_SHORT).show()
                } else if (c.isEmpty()) {
                    Toast.makeText(this, "내용을 입력하세요.", Toast.LENGTH_SHORT).show()
                } else {

                    val postRef = database.getReference("posts").push()
                    val postId = postRef.key

                    if (postId != null) {
                        val post = mapOf(
                            "email" to email,
                            "userNickname" to userNickname.text.toString(),
                            "title" to a,
                            "change" to b,
                            "content" to c,
                            "date" to currentDate,
                            "postId" to postId
                        )

                        // 이미지가 선택되지 않았을 경우
                        if (imageUri == null) {
                            Toast.makeText(this, "이미지를 선택해주세요.", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }

                        // 이미지 업로드
                        val uploadTask = imagesRef.child(postId).putFile(imageUri!!)
                        uploadTask.continueWithTask { task ->
                            if (!task.isSuccessful) {
                                task.exception?.let {
                                    throw it
                                }
                            }
                            // 이미지 업로드 후 다운로드 URL 가져오기
                            imagesRef.child(postId).downloadUrl
                        }.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val downloadUri = task.result
                                // 업로드된 이미지의 다운로드 URL 사용하기
                                val imageUrl = downloadUri.toString()

                                // 게시물 데이터에 이미지 URL 추가하기
                                postRef.child("imageUrl").setValue(imageUrl)
                            } else {
                                Toast.makeText(this, "이미지 업로드에 실패했습니다.", Toast.LENGTH_SHORT).show()
                            }
                        }

                        postRef.setValue(post)
                            .addOnSuccessListener {
                                Toast.makeText(this, "게시물이 성공적으로 작성되었습니다.", Toast.LENGTH_SHORT).show()
                                finish()
                            }
                            .addOnFailureListener {
                                Toast.makeText(this, "게시물 작성에 실패했습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
                            }
                    }
                }
            }
        }
    }

    // 이미지 선택 결과 처리를 위한 onActivityResult 메서드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK) {
            // 선택한 이미지의 Uri 가져오기
            imageUri = data?.data

            if (imageUri != null) {
                // Firebase Storage에 이미지 업로드
                uploadImage(imageUri!!)
            } else {
                Toast.makeText(this, "이미지를 선택하지 않았습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 이미지 업로드 함수
    private fun uploadImage(imageUri: Uri) {
        // 파일 업로드
        val uploadTask = imagesRef.putFile(imageUri)
        uploadTask.continueWithTask { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    throw it
                }
            }
            // 이미지 업로드 후 다운로드 URL 가져오기
            imagesRef.downloadUrl
        }.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val downloadUri = task.result
                // 업로드된 이미지의 다운로드 URL 사용하기
                // 여기서는 게시물 데이터에 추가하거나 필요한 곳에서 사용할 수 있습니다.
                val imageUrl = downloadUri.toString()

                // TODO: 업로드된 이미지 URL 활용하기
            } else {
                Toast.makeText(this, "이미지 업로드에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
