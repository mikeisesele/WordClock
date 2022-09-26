package com.example.timewallpaper

import android.app.Application
import com.example.timewallpaper.util.Domain
import com.example.timewallpaper.util.SharedPrefUtils
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Domain.integrateWith(this)
        instance = this
    }

    companion object {
        lateinit var instance: App
            private set

        var sharedPrefUtils: SharedPrefUtils? = null
    }
}
