package com.example.shaadiassignment.data.model.userdetailmodels

import androidx.room.Embedded

data class Location(
    val city: String,
    @Embedded
    val coordinates: Coordinates,
    val country: String,
    val postcode: String,
    val state: String,
    @Embedded
    val street: Street,
    @Embedded
    val timezone: Timezone
)