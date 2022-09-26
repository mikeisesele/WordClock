package com.example.timewallpaper.domain.state

data class TimeState(
    val timeString: String = "00:00:00",
    val hour: Int = 0,
    val minute: Int = 0,
    val second: Int = 0,
    val ampm: String = "",
    val hourInWords: String = "",
    val minuteInWords: String = "",
    val secondInWords: String = "",
)
