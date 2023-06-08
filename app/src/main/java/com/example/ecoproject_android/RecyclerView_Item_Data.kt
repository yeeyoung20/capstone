package com.example.ecoproject_android

import android.os.Parcel
import android.os.Parcelable

data class RecyclerView_Item_Data(val title : String, val img : ByteArray) : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readString()!!,
//        parcel.readInt()
//    )
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(title)
//        parcel.writeInt(img)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<RecyclerView_Item_Data> {
//        override fun createFromParcel(parcel: Parcel): RecyclerView_Item_Data {
//            return RecyclerView_Item_Data(parcel)
//        }
//
//        override fun newArray(size: Int): Array<RecyclerView_Item_Data?> {
//            return arrayOfNulls(size)
//        }
//    }
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

    companion object CREATOR : Parcelable.Creator<RecyclerView_Item_Data> {
        override fun createFromParcel(parcel: Parcel): RecyclerView_Item_Data {
            return RecyclerView_Item_Data(parcel)
        }

        override fun newArray(size: Int): Array<RecyclerView_Item_Data?> {
            return arrayOfNulls(size)
        }
    }
}
