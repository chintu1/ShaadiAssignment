package com.example.shaadiassignment.data.remote.apis

import com.example.searchmyimage.utils.ConstantClass
import com.example.shaadiassignment.data.model.userdetailmodels.UserDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserDetailsApi {

    @GET(".")
    suspend fun getUserDetails(@Query("results") responseCount: Int= ConstantClass.DETAULT_USER_REPONSE_SIZE): UserDetailResponse
}