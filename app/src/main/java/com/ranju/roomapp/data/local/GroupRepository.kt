package com.ranju.roomapp.data.local

import android.content.Context
import androidx.lifecycle.LiveData
import com.ranju.roomapp.data.provider.ApiClient
import com.ranju.roomapp.data.provider.Constants.DEALER
import com.ranju.roomapp.data.remote.GroupApi
import com.ranju.roomapp.data.remote.model.Baseurl
import com.ranju.roomapp.data.remote.model.Group
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GroupRepository @Inject constructor(
   private val groupDao: GroupDao,
//    private val groupApi: GroupApi,
    @ApplicationContext private val context: Context
){
    suspend fun fetchGroups(userId: String,userType: String) {
        val groupApi: GroupApi = ApiClient.getInstance().create(GroupApi::class.java)
        val response = try {
            groupApi.getCropGroup(userId)
        } catch (e: Exception) {
            null
        }
        if (response != null && response.isSuccessful) {
            response.body()?.data?.static_data?.forEach { insertGroups(it) }
            if (userType == DEALER){
                response.body()?.data?.dealer_group?.forEach { insertGroups(it) }
                response.body()?.data?.group_data?.forEach { insertGroups(it) }
            }
            response.body()?.base_url?.let { insertUrls(it) }
        }
    }
    fun getAllGroups() = groupDao.getAllGroups()
    fun getAllUrls() :LiveData<Baseurl>{
         return  groupDao.getAllUrls()
    }

    private suspend fun insertGroups(group: Group) {
            groupDao.insertGroup(group)
        }
    private suspend fun insertUrls(baseurl: Baseurl) {
            groupDao.insertUrls(baseurl)
        }

}