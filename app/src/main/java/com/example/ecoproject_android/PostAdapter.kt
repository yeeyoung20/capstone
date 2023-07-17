package com.example.ecoproject_android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PostAdapter(
    private val context: Context,
    private val resource: Int,
    private val postList: MutableList<Post>,
    val itemClickListener: (Post) -> Unit
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(resource, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = postList[position]
        holder.titleTextView.text = post.title
        holder.changeTextView.text = post.change
        holder.userTextView.text = post.userNickname

        // Glide를 사용하여 이미지 로드
        Glide.with(context)
            .load(post.imageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_title)
        val changeTextView: TextView = view.findViewById(R.id.item_change)
        val userTextView: TextView = view.findViewById(R.id.item_user_nickname)
        val imageView: ImageView = view.findViewById(R.id.item_image)

        init {
            view.setOnClickListener {
                val post = postList[adapterPosition]
                itemClickListener(post) // ViewHolder가 클릭될 때 콜백을 호출
            }
        }
    }
}
