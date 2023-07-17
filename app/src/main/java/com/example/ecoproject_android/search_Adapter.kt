package com.example.ecoproject_android

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class search_Adapter(var mList:List<search_Item_Data>) : RecyclerView.Adapter<search_Adapter.RecyclerView_Item_Holder>() {

    var onItemClick : ((search_Item_Data) -> Unit)?=null

    inner class RecyclerView_Item_Holder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val img : ImageView = itemView.findViewById(R.id.searchitemimgtest)
        val title : TextView = itemView.findViewById(R.id.searchitemtexttest)

    }

    fun setFilteredList(mList: List<search_Item_Data>){
        this.mList=mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView_Item_Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_search_item,parent,false)
        return RecyclerView_Item_Holder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView_Item_Holder, position: Int) {
        val recyclerView_item_data = mList[position]
        val byteArray = mList[position].img
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        holder.img.setImageBitmap(bitmap)
        holder.title.text = mList[position].title

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(recyclerView_item_data)
        }
    }


    override fun getItemCount(): Int {

        return mList.size
    }
}