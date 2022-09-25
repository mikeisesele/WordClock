package com.example.timewallpaper.util

sealed class AppScreenRoutes(val routes: String) {
    object TimeScreen : AppScreenRoutes("time_screen")
    object SettingScreen : AppScreenRoutes("setting_screen")
}


