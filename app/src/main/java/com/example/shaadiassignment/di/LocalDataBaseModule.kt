package com.example.shaadiassignment.di

import android.content.Context
import androidx.room.Room
import com.example.searchmyimage.utils.ConstantClass.ROOM_DATABASE_NAME
import com.example.shaadiassignment.data.local.LocalDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataBaseModule {

    @Provides
    @Singleton
    fun provideLocalDataBase(@ApplicationContext appContext:Context)= Room.databaseBuilder(appContext, LocalDataBase::class.java, ROOM_DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideUserDetailsDao(localDataBase: LocalDataBase)=localDataBase.userDetailDao()

}