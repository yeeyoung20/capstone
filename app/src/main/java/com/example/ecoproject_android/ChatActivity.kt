package com.example.ecoproject_android

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.collections.Map


class ChatActivity : AppCompatActivity() {

    var firebaseUser: FirebaseUser? = null
    private lateinit var database: FirebaseDatabase

    lateinit var userid: TextView
    lateinit var back: AppCompatImageView
    lateinit var inputMessage: EditText
    lateinit var sendMessage: FrameLayout
    lateinit var progressBar: ProgressBar
    var chatList = ArrayList<Chat> ()
    var receiverNickname : String ?=null
    var senderNickname : String ?=null
    private lateinit var chatRectclerView: RecyclerView
    private lateinit var chatAdapter : ChatAdapter
    var conversionId : String ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)


        chatRectclerView = findViewById(R.id.chatRectclerView)
        userid = findViewById(R.id.userId)
        back = findViewById(R.id.back)
        inputMessage = findViewById(R.id.inputMessage)
        sendMessage = findViewById(R.id.layoutsend)
        progressBar = findViewById(R.id.progressBar)

        firebaseUser = FirebaseAuth.getInstance().currentUser
        var userUid = intent.getStringExtra("userUid")
        val senderId = FirebaseAuth.getInstance().currentUser!!.uid
        back.setOnClickListener({
            finish()
        })
        sendMessage.setOnClickListener{
            var message: String? = null
            message = inputMessage.text.toString()

            if (message != null) {
                sendMessage(senderId, userUid!!, message)
                inputMessage.setText("")
            }
        }

        //함수??,메소드??들
        readUser()
        init()
        readMessage(senderId, userUid!!)
    }
    fun getTime(): String? {
        val now = System.currentTimeMillis()
        val date = Date(now)
        val timeFormat = SimpleDateFormat("yyyy.MM.dd a H:mm:ss", Locale.KOREA)
        return timeFormat.format(date)
    }
    fun sendMessage(senderId: String, receiverId: String, Message: String) {
        var reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("chat")
        var hashMap : HashMap<String, String> = HashMap()
        hashMap.put("senderId",senderId)
        hashMap.put("receiverId",receiverId)
        hashMap.put("message",Message)
        hashMap.put("date",getTime()!!)
        reference.push().setValue(hashMap)

        if(conversionId != null){
            updateConversion(Message)
        }else{
            var hashMap : HashMap<String, Any> = HashMap()
            hashMap.put("senderId",senderId)
            hashMap.put("receiverId",receiverId)
            hashMap.put("message",Message)
            hashMap.put("date",getTime()!!)
            hashMap.put("receiverNickname",receiverNickname!!)
            hashMap.put("senderNickname",senderNickname!!)
            addConversion(hashMap)
        }

    }
    fun init(){
        chatList = ArrayList()
        chatAdapter = ChatAdapter(this@ChatActivity,chatList)
        chatRectclerView.adapter = chatAdapter
        database = FirebaseDatabase.getInstance()
    }

    fun readMessage(senderId: String, receiverId: String){
        var reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("chat")
        reference.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val chat = snapshot.getValue(Chat::class.java)
                if (chat != null && (chat.senderId == senderId && chat.receiverId == receiverId || chat.senderId == receiverId && chat.receiverId == senderId)) {
                    chatList.add(chat)
                    chatAdapter.notifyItemInserted(chatList.size - 1)
                    chatRectclerView.smoothScrollToPosition(chatList.size - 1)
                    chatRectclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    if(conversionId == null)
                    {
                        checkForConversion()
                    }else{

                    }
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {
                Log.d("ChatActivity", "Error: ${error.message}")
            }

        })

    }

    fun readUser(){
        val builder = AlertDialog.Builder(this)
        var receiverId = intent.getStringExtra("userUid")
        val senderId = FirebaseAuth.getInstance().currentUser!!.uid
        var reference = FirebaseDatabase.getInstance().getReference("users")
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                val receiver = snapshot.child(receiverId!!).getValue(User::class.java)
                val sender = snapshot.child(senderId).getValue(User::class.java)
                if (receiver == null || sender == null) {
                    builder.setMessage("데이터를 가져오는데 실패했습니다")
                        .setPositiveButton("확인") { dialog, id ->
                            finish()
                        }
                        .create()
                        .show()
                    finish()
                } else {
                    userid.setText(receiver.userNickname)
                    receiverNickname = receiver.userNickname
                    senderNickname = sender.userNickname
                }
            }
        })


    }

    private fun checkForConversionRemotely(senderId: String, receiverId: String) {
        val databaseReference = FirebaseDatabase.getInstance().getReference("conversations")
        val query = databaseReference.orderByChild("senderId").equalTo(senderId)
        val valueEventListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange( dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (snapshot in dataSnapshot.children) {
                        if (snapshot.child("receiverId").getValue(String::class.java) == receiverId) {
                            conversionId = snapshot.key
                            break
                        }
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle error
            }
        }

        query.addValueEventListener(valueEventListener)
    }

    private fun checkForConversion() {
        var userUid = intent.getStringExtra("userUid")
        val senderId = FirebaseAuth.getInstance().currentUser!!.uid
        if (chatList.size !== 0) {
            checkForConversionRemotely(senderId, userUid!!)
            checkForConversionRemotely(userUid!!, senderId)
        }
    }

    private fun addConversion(conversion: HashMap<String, Any>) {
        val databaseReference = FirebaseDatabase.getInstance()
            .getReference("conversations")

        val conversationKey = databaseReference.push().key
        if (conversationKey != null) {
            databaseReference.child(conversationKey)
                .setValue(conversion)
                .addOnSuccessListener { conversionId = conversationKey }
        }
    }

    private fun updateConversion(message: String) {
        val documentReference = FirebaseDatabase.getInstance()
            .getReference("conversations")
            .child(conversionId!!)
        var hashMap : HashMap<String, String> = HashMap()
        hashMap.put("message", message)
        hashMap.put("date", getTime()!!)
        documentReference.updateChildren(hashMap as Map<String, Any>)
    }

}