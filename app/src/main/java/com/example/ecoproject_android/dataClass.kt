package com.example.ecoproject_android

import android.os.Parcel
import android.os.Parcelable
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
    var nickname: String?=null,
    var isChecked: Boolean = false
)

data class search_Item_Data(val title : String, val img : ByteArray) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.createByteArray() ?: ByteArray(0)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeByteArray(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<search_Item_Data> {
        override fun createFromParcel(parcel: Parcel): search_Item_Data {
            return search_Item_Data(parcel)
        }

        override fun newArray(size: Int): Array<search_Item_Data?> {
            return arrayOfNulls(size)
        }
    }
}

data class CategoryMain_Item_Data(val title : String, val img : ByteArray) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.createByteArray() ?: ByteArray(0)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeByteArray(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CategoryMain_Item_Data> {
        override fun createFromParcel(parcel: Parcel): CategoryMain_Item_Data {
            return CategoryMain_Item_Data(parcel)
        }

        override fun newArray(size: Int): Array<CategoryMain_Item_Data?> {
            return arrayOfNulls(size)
        }
    }
}

