package com.ranju.roomapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ranju.roomapp.data.remote.model.Baseurl
import com.ranju.roomapp.data.remote.model.Group
import java.util.*

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroup(group: Group)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUrls(base_url: Baseurl)

    @Query("SELECT * FROM groups")
    fun getAllGroups(): LiveData<List<Group>>

    @Query("SELECT * FROM Base_url")
    fun getAllUrls(): LiveData<Baseurl>

    @Update
    suspend fun updateGroup(group: Group)
}