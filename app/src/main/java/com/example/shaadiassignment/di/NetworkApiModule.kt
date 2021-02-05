package com.example.shaadiassignment.di

import com.example.shaadiassignment.data.remote.builder.ApiBuilder
import com.example.shaadiassignment.data.remote.apis.UserDetailsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkApiModule {

    @Provides
    @Singleton
    fun providesUserDetailsApi(apiBuilder: ApiBuilder) =
        apiBuilder.buildService(UserDetailsApi::class.java)
}