package com.example.shaadiassignment.data.model.userdetailmodels

import androidx.room.ColumnInfo

data class Id(
        @ColumnInfo(name = "id_name")
        val name: String?,
        val value: String?
)