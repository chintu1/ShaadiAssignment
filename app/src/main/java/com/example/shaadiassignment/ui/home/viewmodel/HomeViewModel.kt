package com.example.shaadiassignment.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.shaadiassignment.data.repository.UserDetailRepository
import com.example.shaadiassignment.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userDetailRepository: UserDetailRepository) : ViewModel() {

    val userDetails = liveData{
        emit(DataState.Loading)

        try {
            val userDetailsFromDb=userDetailRepository.getUserDetailsDb()
            if(userDetailsFromDb.size!=0){
                emit(DataState.Success(userDetailsFromDb))
            }
        }catch (e:Exception){
            Timber.e(e)
        }

        try {
            val userDetails=userDetailRepository.getUserDetails().results
            emit(DataState.Success(userDetails))
            userDetailRepository.insertAllUserDetailsDb(userDetails)
        }catch (e:Exception){
          Timber.e(e)
          emit(DataState.Error(e))
        }
    }
}