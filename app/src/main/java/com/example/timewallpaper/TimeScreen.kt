package com.example.timewallpaper

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import com.example.timewallpaper.composables.TimeComposable
import com.example.timewallpaper.state.ScreenTimeState
import com.example.timewallpaper.util.AppThemeState

@Composable
fun WordTimeScreen(navController: NavController, state: ScreenTimeState, appTheme: MutableState<AppThemeState>){
    TimeComposable(state)
}