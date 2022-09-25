package com.example.timewallpaper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.timewallpaper.composables.TimeComposable
import com.example.timewallpaper.state.ScreenTimeState
import com.example.timewallpaper.ui.theme.ClockWallPaperTheme
import com.example.timewallpaper.ui.theme.appBarDarkBlackDark
import com.example.timewallpaper.ui.theme.appScaffoldColor
import com.example.timewallpaper.util.AppThemeState
import com.example.timewallpaper.util.SystemUiController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = TimeViewModel()
        viewModel.start()

        setContent {
            val state = viewModel.screenTime.collectAsState().value
            val systemUiController = remember { SystemUiController(window) }
            val appTheme = remember { mutableStateOf(AppThemeState()) }

            BaseView(appTheme.value, systemUiController) {
                val navController = rememberNavController()
//                Navigation(navController = navController, appTheme)
                TimeComposable(state)
            }
        }
    }
}

@Composable
fun BaseView(
    appThemeState: AppThemeState,
    systemUiController: SystemUiController?,
    statusBarColor: Color = MaterialTheme.colors.surface,
    content: @Composable () -> Unit
) {
    systemUiController?.setStatusBarColor(
        color = if (appThemeState.darkTheme) appBarDarkBlackDark else appScaffoldColor,
        darkIcons = !appThemeState.darkTheme
    )
    ClockWallPaperTheme(
        darkTheme = appThemeState.darkTheme,
        colorPallet = appThemeState.pallet
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ClockWallPaperTheme {
        TimeComposable(state = ScreenTimeState())
    }
}
