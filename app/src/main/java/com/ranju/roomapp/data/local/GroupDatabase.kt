package com.ranju.roomapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ranju.roomapp.data.remote.model.Baseurl
import com.ranju.roomapp.data.remote.model.Group

@Database(
    entities = [Group::class,Baseurl::class],
    version = 1
)
abstract class GroupDatabase :RoomDatabase(){
    abstract fun groupDao(): GroupDao
}