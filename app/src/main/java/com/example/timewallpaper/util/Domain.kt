package com.example.timewallpaper.util

import com.example.timewallpaper.App

object Domain {
    lateinit var application: App private set

    fun integrateWith(app: App) {
        Domain.application = app
    }
}
