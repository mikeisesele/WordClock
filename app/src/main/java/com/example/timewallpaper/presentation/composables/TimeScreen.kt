package com.example.timewallpaper.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import com.example.timewallpaper.domain.state.ScreenTimeState
import com.example.timewallpaper.util.AppThemeState

@Composable
fun WordTimeScreen(navController: NavController, state: ScreenTimeState, appTheme: MutableState<AppThemeState>){
    TimeComposable(state, appTheme.value)
}