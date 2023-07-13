package com.example.ecoproject_android


//import com.example.ecoproject_android.adapters.UsersAdapter

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Date
import java.util.Locale
import java.text.SimpleDateFormat



class ChattingMain : AppCompatActivity() {
    var firebaseUser: FirebaseUser? = null
    private lateinit var database: FirebaseDatabase

    private lateinit var chatRectclerView: RecyclerView
    private lateinit var conversations: ArrayList<Chat>
    private lateinit var conversationsAdapter: ChattingMainAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatting_main)

        val back=findViewById<Button>(R.id.back)
        chatRectclerView = findViewById(R.id.chattingRecyclerView)
        init()
        listenConversations()
        back.setOnClickListener{finish()}

    }

//    private fun init(){
//        conversations = ArrayList()
//        conversationsAdapter = ChattingMainAdapter(this@ChattingMain,conversations)
//        chatRectclerView.adapter = conversationsAdapter
//        database = FirebaseDatabase.getInstance()
//    }

    private fun init(){
        conversations = ArrayList()
        conversationsAdapter = ChattingMainAdapter(this@ChattingMain, conversations)
        chatRectclerView.adapter = conversationsAdapter
        chatRectclerView.layoutManager = LinearLayoutManager(this) // Add this line
        database = FirebaseDatabase.getInstance()
    }


//    private val valueEventListener = object : ValueEventListener {
//        override fun onDataChange(dataSnapshot: DataSnapshot) {
//            // 데이터가 변경될 때 호출됨
//            for (data in dataSnapshot.children) {
//                val senderId = data.child("senderId").getValue(String::class.java)
//                val receiverId = data.child("receiverId").getValue(String::class.java)
//                val userId = FirebaseAuth.getInstance().currentUser!!.uid
//
//                if (userId == senderId) {
//                    val conversionName = data.child("receiverNickname").getValue(String::class.java)
//                    val conversionId = data.child("receiverId").getValue(String::class.java)
//                    val message = data.child("message").getValue(String::class.java)
//                    val date = data.child("date").getValue(String::class.java)
//                    val chat = Chat(
//                        senderId = senderId,
//                        receiverId = receiverId,
//                        message = message,
//                        date = date,
//                        conversionId = conversionId,
//                        nickname = conversionName
//                    )
//                    conversations.add(chat)
//                } else {
//                    val conversionName = data.child("senderNickname").getValue(String::class.java)
//                    val conversionId = data.child("senderId").getValue(String::class.java)
//                    val message = data.child("message").getValue(String::class.java)
//                    val date = data.child("date").getValue(String::class.java)
//                    val chat = Chat(
//                        senderId = senderId,
//                        receiverId = receiverId,
//                        message = message,
//                        date = date,
//                        conversionId = conversionId,
//                        nickname = conversionName
//                    )
//                    conversations.add(chat)
//                    conversations.sortBy { it.date }
//                    conversationsAdapter.notifyDataSetChanged()
//                    chatRectclerView.smoothScrollToPosition(0)
//                }
//            }
//        }
//
//        override fun onCancelled(databaseError: DatabaseError) {
//            // 작업이 취소될 때 호출됨
//        }
//
//    }

//    private val valueEventListener = object : ChildEventListener {
//        override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
//
//            val senderId = dataSnapshot.child("senderId").getValue(String::class.java)
//            val receiverId = dataSnapshot.child("receiverId").getValue(String::class.java)
//            val userId = FirebaseAuth.getInstance().currentUser!!.uid
//
//            if (userId == senderId) {
//                val conversionName =
//                    dataSnapshot.child("receiverNickname").getValue(String::class.java)
//                val conversionId = dataSnapshot.child("receiverId").getValue(String::class.java)
//                val message = dataSnapshot.child("message").getValue(String::class.java)
//                val date = dataSnapshot.child("date").getValue(String::class.java)
//                val chat = Chat(
//                    senderId = senderId,
//                    receiverId = receiverId,
//                    message = message,
//                    date = date,
//                    conversionId = conversionId,
//                    nickname = conversionName
//                )
//                Log.d("정렬",conversations.toString())
//                conversations.add(chat)
//                conversations.sortByDescending { it.date }
//                conversationsAdapter.notifyDataSetChanged()
//                chatRectclerView.visibility = View.VISIBLE
//                chatRectclerView.smoothScrollToPosition(0)
//                Log.d("정렬",conversations.toString())
//
//            } else {
//                val conversionName =
//                    dataSnapshot.child("senderNickname").getValue(String::class.java)
//                val conversionId = dataSnapshot.child("senderId").getValue(String::class.java)
//                val message = dataSnapshot.child("message").getValue(String::class.java)
//                val date = dataSnapshot.child("date").getValue(String::class.java)
//                val chat = Chat(
//                    senderId = senderId,
//                    receiverId = receiverId,
//                    message = message,
//                    date = date,
//                    conversionId = conversionId,
//                    nickname = conversionName
//                )
//                Log.d("정렬",conversations.toString())
//                conversations.add(chat)
//                conversations.sortByDescending { it.date }
//                conversationsAdapter.notifyDataSetChanged()
//                chatRectclerView.smoothScrollToPosition(0)
//                chatRectclerView.visibility = View.VISIBLE
//                Log.d("정렬",conversations.toString())
//            }
//            Log.d("정렬",conversations.toString())
//            conversations.sortByDescending { it.date }
//            conversationsAdapter.notifyDataSetChanged()
//            chatRectclerView.smoothScrollToPosition(0)
//            chatRectclerView.visibility = View.VISIBLE
//            Log.d("정렬",conversations.toString())
//
//        }
//
//        override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
//            val senderId = dataSnapshot.child("senderId").getValue(String::class.java)
//            val receiverId = dataSnapshot.child("receiverId").getValue(String::class.java)
//
//            for (i in conversations.indices) {
//                if (conversations[i].senderId == senderId && conversations[i].receiverId == receiverId) {
//                    conversations[i].message = dataSnapshot.child("message").getValue(String::class.java)
//                    conversations[i].date = dataSnapshot.child("date").getValue(String::class.java)
//                    break
//                }
//            }
//            conversations.sortByDescending { it.date }
//            conversationsAdapter.notifyDataSetChanged()
//            chatRectclerView.smoothScrollToPosition(0)
//            chatRectclerView.visibility = View.VISIBLE
//        }
//
//        override fun onChildRemoved(snapshot: DataSnapshot) {
//            TODO("Not yet implemented")
//        }
//
//        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
//            TODO("Not yet implemented")
//        }
//
//        override fun onCancelled(error: DatabaseError) {
//            TODO("Not yet implemented")
//        }
//    }

    private val valueEventListener = object : ChildEventListener {
        override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
            val userId = FirebaseAuth.getInstance().currentUser!!.uid
            val chat = dataSnapshot.getValue(Chat::class.java)
            if (userId.equals(chat!!.senderId) ) {
                chat.conversionId = chat.receiverId
                chat.nickname = chat.receiverNickname
            }else{
                chat.conversionId = chat.senderId
                chat.nickname = chat.senderNickname
            }
            conversations.add(chat)
            conversations.sortByDescending { it.date }
            conversationsAdapter.notifyDataSetChanged()
            chatRectclerView.smoothScrollToPosition(0)
            chatRectclerView.visibility = View.VISIBLE
        }

        override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
            for (i in conversations.indices){

                val senderId = dataSnapshot.child("senderId").getValue(String::class.java)
                val receiverId = dataSnapshot.child("receiverId").getValue(String::class.java)
                if(conversations[i].senderId.equals(senderId) && conversations[i].receiverId.equals(receiverId)) {
                    conversations[i].message=dataSnapshot.child("message").getValue(String::class.java)
                    conversations[i].date=dataSnapshot.child("date").getValue(String::class.java)
                    break
               }

            }
            conversations.sortByDescending { it.date }
            conversationsAdapter.notifyDataSetChanged()
            chatRectclerView.smoothScrollToPosition(0)
            chatRectclerView.visibility = View.VISIBLE
        }

        override fun onChildRemoved(snapshot: DataSnapshot) {
            TODO("Not yet implemented")
        }

        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
            TODO("Not yet implemented")
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }

    }
        private fun listenConversations() {
            val conversationsRef = database.getReference("conversations")
            val userId = FirebaseAuth.getInstance().currentUser!!.uid
            conversationsRef.orderByChild("senderId").equalTo(userId)
                .addChildEventListener(valueEventListener)
            conversationsRef.orderByChild("receiverId").equalTo(userId)
                .addChildEventListener(valueEventListener)

        }


}


