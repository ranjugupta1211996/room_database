package com.ranju.roomapp.data.provider

import android.content.Context
import androidx.room.Room
import com.ranju.roomapp.data.local.GroupDatabase
import com.ranju.roomapp.data.provider.Constants.BASE_URL
import com.ranju.roomapp.data.provider.Constants.DATABASE_NAME
import com.ranju.roomapp.data.remote.GroupApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideGroupDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, GroupDatabase::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideGroupDao(db: GroupDatabase) = db.groupDao()

//    @Singleton
//    @Provides
//    fun provideGroupApi(): GroupApi = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(GroupApi::class.java)
}