package com.example.timewallpaper.state

data class ScreenTimeState(
    val am: Boolean = false,
    val pm: Boolean = false,
    val one: Boolean = false,
    val two: Boolean = false,
    val three: Boolean = false,
    val four: Boolean = false,
    val five: Boolean = false,
    val six: Boolean = false,
    val seven: Boolean = false,
    val eight: Boolean = false,
    val nine: Boolean = false,
    val ten: Boolean = false,
    val eleven: Boolean = false,
    val twelve: Boolean = false,
    val quarter: Boolean = false,
    val half: Boolean = false,
    val to: Boolean = false,
    val past: Boolean = false,
    val oClock: Boolean = false,
    val fifteen: Boolean = false,
    val twenty: Boolean = false,
    val thirty: Boolean = false,
    val forty: Boolean = false,
    val fifty: Boolean = false,
    val midnight: Boolean = false,
    val a: Boolean = false,
    val it: Boolean = true,
    val isTime: Boolean = true,
    val hour: Boolean = false,
    val minute: Boolean = false,
    val seconds: Boolean = false,
    val hValue: String = "HOUR",
    val mValue: String = "MINUTE",
    val sValue: String = "SECONDS"
)
