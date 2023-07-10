package com.example.ecoproject_android

import android.provider.ContactsContract.CommonDataKinds.Nickname

data class Post(
    val userUid: String? = null,
    val email: String? = null,
    val userNickname: String? = null,
    val title: String? = null,
    val change: String? = null,
    val content: String? = null,
    val date: String? = null,
    val postId: String? = null,
    val imageUrl: String? = null // imageUrl 필드 추가

)

data class User(
    val userUid: String? = null,
    val userNickname: String? = null,
    val zone: String? = null,
)

data class Chat(
    val senderId: String? = null,
    val receiverId: String? = null,
    val message : String?=null,
    val date : String?=null,
    val receiverNickname: String? = null,
    val senderNickname: String? = null,
    val conversionId : String ?=null,
    val nickname: String?=null
)

data class Conversations(
    val senderId: String? = null,
    val receiverId: String? = null,
    var message : String?=null,
    var date : String?=null,
    val nickname: String?=null
)
