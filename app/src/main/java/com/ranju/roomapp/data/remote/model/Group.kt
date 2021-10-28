package com.ranju.roomapp.data.remote.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "groups")
data class Group(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("pkey")
    val id: String,
    val crop_group_name: String,
    val crop_group_img: String,
    val removed_by: String?,
    val is_mandatory: String?,
    val unread_messages: String?,
    val dealer_unread_messages: String?,
    val group_type: String?,
    val dealer_id: String?,
    val dealer_available: String?,
)


