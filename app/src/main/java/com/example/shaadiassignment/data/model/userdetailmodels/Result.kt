package com.example.shaadiassignment.data.model.userdetailmodels

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Result(
        @PrimaryKey(autoGenerate = true)
        var _id: Int=0 ,
        val cell: String,
        @Embedded
        val dob: Dob,
        val email: String,
        val gender: String,
        @Embedded
        val id: Id,
        @Embedded
        val location: Location,
        @Embedded
        val login: Login,
        @Embedded
        val name: Name,
        val nat: String,
        val phone: String,
        @Embedded
        val picture: Picture,
        @Embedded
        val registered: Registered
)