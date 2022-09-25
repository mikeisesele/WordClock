package com.example.timescreen.composables.words

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun O(isActive: Boolean = false) {
    Text(
        text = "O'",
        color = if (isActive) {
            Color.White
        } else {
            Color.Gray
        }
    )
}
