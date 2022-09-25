package com.example.timewallpaper.composables.timegroup

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun AMPM(ampm: String, isActive: Boolean = false) {
    Text(
        text = ampm,
        color = if (isActive) {
            Color.White
        } else {
            Color.Gray.copy(alpha = 0.35f)
        },
        letterSpacing = 10.sp
    )
}
