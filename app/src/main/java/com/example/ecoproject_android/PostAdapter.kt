package com.example.ecoproject_android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class PostAdapter(
    context: Context,
    private val resource: Int,
    private val postList: MutableList<Post>
) : ArrayAdapter<Post>(context, resource, postList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        val viewHolder: ViewHolder

        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(resource, parent, false)
            viewHolder = ViewHolder()
            viewHolder.titleTextView = listItemView.findViewById(R.id.item_title)
            viewHolder.changeTextView = listItemView.findViewById(R.id.item_change)
            viewHolder.userTextView = listItemView.findViewById(R.id.item_user_nickname)
            viewHolder.imageView = listItemView.findViewById(R.id.item_image)
            listItemView.tag = viewHolder
        } else {
            viewHolder = listItemView.tag as ViewHolder
        }

        val post = postList[position]
        viewHolder.titleTextView?.text = post.title
        viewHolder.changeTextView?.text = post.change
        viewHolder.userTextView?.text = post.userNickname

        // Glide를 사용하여 이미지 로드
        Glide.with(context)
            .load(post.imageUrl)
            .into(viewHolder.imageView!!)

        return listItemView!!
    }

    private class ViewHolder {
        var titleTextView: TextView? = null
        var changeTextView: TextView? = null
        var userTextView: TextView? = null
        var imageView: ImageView? = null
    }
}