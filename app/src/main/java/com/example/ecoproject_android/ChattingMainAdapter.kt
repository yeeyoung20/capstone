package com.example.ecoproject_android
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ChattingMainAdapter (private val context : Context, private  val userMessageList : ArrayList<Chat>) : RecyclerView.Adapter<ChattingMainAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var userMessage : TextView = view.findViewById(R.id.userMessage)
        var username : TextView = view.findViewById(R.id.userName)
        var conversioncard : ConstraintLayout = view.findViewById(R.id.conversioncard)
        var checkmessage : View = view.findViewById(R.id.checkmessage)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_container_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  userMessageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userMessageList = userMessageList[position]
        holder.userMessage.setText(userMessageList.message)
        holder.username.setText(userMessageList.nickname)
        holder.checkmessage.visibility = if (userMessageList.isChecked) View.GONE else View.VISIBLE
        holder.conversioncard.setOnClickListener {
            val intent = Intent(context,ChatActivity::class.java)
            intent.putExtra("userUid",userMessageList.conversionId)
            holder.checkmessage.visibility=View.GONE
            userMessageList.isChecked = true
            context.startActivity(intent)
        }
    }


}