package com.example.ecoproject_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter (list : ArrayList<UserData>) : RecyclerView.Adapter<CustonViewHolder>(){
    var mList : ArrayList<UserData> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustonViewHolder {
        TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sign_up_list, parent, false)
        return CustonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: CustonViewHolder, position: Int) {
        TODO("Not yet implemented")
        val u = mList.get(position)
        holder.setHolder(u)
    }

}

class CustonViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    fun setHolder(userData : UserData) {
    }
}