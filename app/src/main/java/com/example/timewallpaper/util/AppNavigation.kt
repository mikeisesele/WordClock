package com.example.timewallpaper.util

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.timewallpaper.WordTimeScreen
import com.example.timewallpaper.state.ScreenTimeState
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.DelicateCoroutinesApi

@ExperimentalPagerApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@DelicateCoroutinesApi
@Composable
fun TimeNavigation(navController: NavHostController, appTheme: MutableState<AppThemeState>, state: ScreenTimeState) {
    NavHost(navController = navController, startDestination = AppScreenRoutes.TimeScreen.routes) {
        composable(route = AppScreenRoutes.TimeScreen.routes) {
            WordTimeScreen(navController = navController, appTheme = appTheme, state = state)
        }
    }
}
