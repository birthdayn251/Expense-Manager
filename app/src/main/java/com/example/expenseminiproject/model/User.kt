package com.example.expenseminiproject.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "User",
    indices = [
        androidx.room.Index(value = ["username"], unique = true),
        androidx.room.Index(value = ["email"], unique = true),
        androidx.room.Index(value = ["phone"], unique = true)
    ]
)
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val username: String,
    var password: String,
    var email: String? = null,
    var phone: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(userId)
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeString(email)
        parcel.writeString(phone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
