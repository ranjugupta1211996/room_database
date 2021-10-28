package com.ranju.roomapp.data.remote.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class GroupList(
    @SerializedName("group_data")
    var group_data: ArrayList<Group> = ArrayList<Group>(),

    @SerializedName("dealer_group")
    var dealer_group: ArrayList<Group> = ArrayList<Group>(),

    @SerializedName("static_data")
    var static_data: ArrayList<Group> = ArrayList<Group>(),

    @SerializedName("static_dealer")
    var static_dealer: ArrayList<Group> = ArrayList<Group>()
)