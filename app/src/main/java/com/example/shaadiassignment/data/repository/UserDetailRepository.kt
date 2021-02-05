package com.example.shaadiassignment.data.repository

import com.example.searchmyimage.utils.ConstantClass.DETAULT_USER_REPONSE_SIZE
import com.example.shaadiassignment.data.local.dao.UserDetailDao
import com.example.shaadiassignment.data.model.userdetailmodels.Result
import com.example.shaadiassignment.data.remote.apis.UserDetailsApi
import javax.inject.Inject

class UserDetailRepository @Inject constructor(private val userDetailsApi: UserDetailsApi, private val userDetailDao: UserDetailDao) {

    suspend fun getUserDetails(userResponseSize: Int = DETAULT_USER_REPONSE_SIZE)=userDetailsApi.getUserDetails();

    suspend fun getUserDetailsDb()=userDetailDao.getAllUserDetails();

    suspend fun insertAllUserDetailsDb(userDetails:List<Result>)=userDetailDao.updateUsersData(userDetails);
}