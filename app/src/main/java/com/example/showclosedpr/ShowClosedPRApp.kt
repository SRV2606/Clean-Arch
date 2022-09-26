package com.example.showclosedpr

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ShowClosedPRApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("SHAW_TAG", "INIT")
    }
}