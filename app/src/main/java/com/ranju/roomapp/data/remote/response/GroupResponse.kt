package com.ranju.roomapp.data.remote.response

import com.google.gson.annotations.SerializedName
import com.ranju.roomapp.data.remote.model.Baseurl
import com.ranju.roomapp.data.remote.model.Group
import com.ranju.roomapp.data.remote.model.GroupList

data class GroupResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("base_url")
    val base_url: Baseurl,
    @SerializedName("data")
    var data: GroupList,
)

