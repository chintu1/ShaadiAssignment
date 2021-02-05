package com.example.shaadiassignment.data.remote.builder

import retrofit2.Retrofit
import javax.inject.Inject

class ApiBuilder @Inject constructor(private  val retrofit: Retrofit) {

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}