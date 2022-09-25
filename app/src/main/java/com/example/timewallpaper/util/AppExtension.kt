package com.example.timewallpaper.util

import com.example.timewallpaper.App


fun getSharedPrefInstance(): SharedPrefUtils {
    return if (App.sharedPrefUtils == null) {
        App.sharedPrefUtils = SharedPrefUtils()
        App.sharedPrefUtils!!
    } else {
        App.sharedPrefUtils!!
    }
}