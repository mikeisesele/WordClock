package com.example.timewallpaper.presentation.composables.hour

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun Three(isActive: Boolean = false) {
    Text(
        text = "THREE",
        color = if (isActive) {
            Color.White
        } else {
            Color.Gray.copy(alpha = 0.35f)
        },
        letterSpacing = 10.sp

    )
}
