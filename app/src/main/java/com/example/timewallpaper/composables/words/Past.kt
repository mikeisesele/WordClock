package com.example.timewallpaper.composables.words

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun Past(isActive: Boolean = false) {
    Text(
        text = "PAST",
        color = if (isActive) {
            Color.White
        } else {
            Color.Gray.copy(alpha = 0.35f)
        },
        letterSpacing = 10.sp
    )
}
