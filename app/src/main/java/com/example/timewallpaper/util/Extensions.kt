package com.example.timewallpaper.util

import android.util.Log

fun Any.log() {
    Log.d("INFORMATION", this.toString())
}

fun log(message: String) {
    Log.d("INFORMATION", message)
}
