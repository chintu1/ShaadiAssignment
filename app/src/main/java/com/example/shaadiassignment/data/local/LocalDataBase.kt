package com.example.shaadiassignment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shaadiassignment.data.local.dao.UserDetailDao
import com.example.shaadiassignment.data.model.userdetailmodels.Result

@Database(entities = [Result::class], version = 1, exportSchema = false)
abstract class LocalDataBase : RoomDatabase(){
    abstract fun userDetailDao():UserDetailDao
}