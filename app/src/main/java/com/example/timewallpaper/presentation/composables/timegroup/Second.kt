package com.example.timewallpaper.presentation.composables.timegroup

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.timewallpaper.presentation.ui.theme.typography

@Composable
fun Second(second: String, isActive: Boolean = false) {
    Text(
        text = second,
        color = if (isActive) {
            Color.White.copy(alpha = 0.4f)
        } else {
            Color.Gray.copy(alpha = 0.35f)
        },
        fontSize = 11.sp,
        letterSpacing = 10.sp,
        style = typography.body1
    )
}
