package com.ranju.roomapp.data.remote.model

import android.os.Parcel
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Base_url")
data class Baseurl (
    @PrimaryKey(autoGenerate = false)
    val id: Int=0,
    @SerializedName("mandatory_group")
    var mandatory_group: String? = null,

    @SerializedName("crop_group")
    var crop_group: String? = null,

    @SerializedName("agrodev_group")
    var agrodev_group: String? = null,

    @SerializedName("dealer_group")
    var dealer_group: String? = null,
)
