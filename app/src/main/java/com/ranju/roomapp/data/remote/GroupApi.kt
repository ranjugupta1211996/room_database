package com.ranju.roomapp.data.remote

import com.ranju.roomapp.data.provider.Constants
import com.ranju.roomapp.data.remote.response.GroupResponse
import retrofit2.Response
import retrofit2.http.*

interface GroupApi {
    @GET(Constants.GET_CROP_GROUP_URL + "/{id}")
    suspend fun getCropGroup(@Path("id") id: String?): Response<GroupResponse>

}