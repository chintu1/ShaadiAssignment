package com.example.shaadiassignment.ui.application

import android.app.Application
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        Timber.plant(Timber.DebugTree())
    }
}