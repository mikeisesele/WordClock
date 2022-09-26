package com.example.timewallpaper.util

import android.util.Log
import java.util.*

fun Any.log() {
    Log.d("INFORMATION", this.toString())
}

fun  log(message: String) {
    Log.d("INFORMATION", message)
}

// perform an operation every second
fun everySecond(operation: () -> Unit) {
    Timer().schedule(
        object : TimerTask() {
            override fun run() {
                operation()
            }
        },
        0,
        1000
    )
}

// perform an operation every minute
fun everyMinute(operation: () -> Unit) {
    Timer().schedule(
        object : TimerTask() {
            override fun run() {
                operation()
            }
        },
        0,
        1000 * 60
    )
}

// perform an operation every hour
fun everyHour(operation: () -> Unit) {
    Timer().schedule(
        object : TimerTask() {
            override fun run() {
                operation()
            }
        },
        0,
        1000 * 60 * 60
    )
}

// perform an operation every day
fun everyDay(operation: () -> Unit) {
    Timer().schedule(
        object : TimerTask() {
            override fun run() {
                operation()
            }
        },
        0,
        1000 * 60 * 60 * 24
    )
}

// perform an operation every week
fun everyWeek(operation: () -> Unit) {
    Timer().schedule(
        object : TimerTask() {
            override fun run() {
                operation()
            }
        },
        0,
        1000 * 60 * 60 * 24 * 7
    )
}
