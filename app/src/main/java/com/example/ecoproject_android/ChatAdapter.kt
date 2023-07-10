package com.example.ecoproject_android
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ChatAdapter (private val context : Context, private  val chatList : ArrayList<Chat>) : RecyclerView.Adapter<ViewHolder>(){

    private val MESSAGE_TYPE_SENDER_KEY = 1
    private val MESSAGE_TYPE_RECEIVER_KEY = 0
    var firebaseUser : FirebaseUser? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        if(viewType == MESSAGE_TYPE_SENDER_KEY) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_container_sent_message, parent, false)
            return senderViewHolder(view)
        } else{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_container_recenived_message, parent, false)
            return receiverViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chatList[position]
        if (getItemViewType(position) == MESSAGE_TYPE_SENDER_KEY) {
            (holder as senderViewHolder).apply {
                message.text = chat.message
                textdatetime.text = chat.date // Chat 클래스의 적절한 속성으로 `datetime`을 바꿉니다.
            }
        } else {
            (holder as receiverViewHolder).apply {
                message.text = chat.message
                textdatetime.text = chat.date // Chat 클래스의 적절한 속성으로 `datetime`을 바꿉니다

            }
        }
    }



    override fun getItemCount(): Int {

        return chatList.size

    }


    class senderViewHolder(view : View) : ViewHolder(view){
        var message : TextView = view.findViewById(R.id.textMessage)
        var textdatetime : TextView = view.findViewById(R.id.textDateTime)
    }

    class receiverViewHolder(view : View) : ViewHolder(view){
        var message : TextView = view.findViewById(R.id.textMessage)
        var textdatetime : TextView = view.findViewById(R.id.textDateTime)
        //var imageprofile : ImageView = view.findViewById(R.id.imageProfile)
    }

    override fun getItemViewType(position: Int): Int {
        firebaseUser = FirebaseAuth.getInstance().currentUser
        if(chatList[position].senderId == firebaseUser!!.uid){
            return  MESSAGE_TYPE_SENDER_KEY
        }else{
            return  MESSAGE_TYPE_RECEIVER_KEY

        }

    }

}