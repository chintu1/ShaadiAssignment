package com.example.shaadiassignment.data.model.userdetailmodels

import androidx.room.ColumnInfo

data class Registered(
    @ColumnInfo(name = "registered_age")
    val age: Int,
    @ColumnInfo(name = "registered_date")
    val date: String
)