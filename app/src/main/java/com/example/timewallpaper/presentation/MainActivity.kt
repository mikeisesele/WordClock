package com.example.timewallpaper.presentation

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.timewallpaper.domain.state.ScreenTimeState
import com.example.timewallpaper.navigation.TimeNavigation
import com.example.timewallpaper.presentation.composables.TimeComposable
import com.example.timewallpaper.presentation.ui.theme.ClockWallPaperTheme
import com.example.timewallpaper.presentation.ui.theme.appBarDarkBlackDark
import com.example.timewallpaper.presentation.ui.theme.appScaffoldColor
import com.example.timewallpaper.util.AppThemeState
import com.example.timewallpaper.util.SystemUiController
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var textToSpeech: TextToSpeech? = null

    @OptIn(
        ExperimentalPagerApi::class,
        ExperimentalFoundationApi::class,
        ExperimentalMaterialApi::class,
        DelicateCoroutinesApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: TimeViewModel by viewModels()
        viewModel.startTime()

        setContent {
            val state = viewModel.screenTime.collectAsState().value
            val systemUiController = remember { SystemUiController(window) }
            val appTheme = remember { mutableStateOf(AppThemeState()) }
            handleSpeaker(state, textToSpeech)

            BaseView(appTheme.value, systemUiController) {
                val navController = rememberNavController()
                TimeNavigation(navController = navController, appTheme, state)
            }
        }
    }

    private fun handleSpeaker(state: ScreenTimeState, textToSpeech: TextToSpeech?) {
        // set up text to speech
        this.textToSpeech = TextToSpeech(this) { status ->
            if (status != TextToSpeech.ERROR) {
                textToSpeech?.language = Locale.UK
                when (state.oClock) {
                    true -> {
                        if (state.secondsInt < 1) {
                            textToSpeech?.speak(
                                listOf("It's exactly ${state.speakHourValue} o'clock ${state.ampm}", "The time is ${state.speakHourValue} ${state.ampm}").random(),
                                TextToSpeech.QUEUE_FLUSH,
                                null
                            )
                        }
                    }
                }
                when (state.thirty) {
                    true -> {
                        if (state.secondsInt < 1) {
                            textToSpeech?.speak(
                                listOf(
                                    "It's half past ${state.speakHourValue} ${state.ampm}",
                                    "It's ${state.speakHourValue} thirty ${state.ampm}"
                                ).random(),
                                TextToSpeech.QUEUE_FLUSH,
                                null
                            )
                        }
                    }
                }
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
