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
    var senderId: String? = null,
    var receiverId: String? = null,
    var message : String?=null,
    var date : String?=null,
    var receiverNickname: String? = null,
    var senderNickname: String? = null,
    var conversionId : String ?=null,
    var nickname: String?=null
)

