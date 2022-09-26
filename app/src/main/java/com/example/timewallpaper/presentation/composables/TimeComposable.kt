package com.example.timewallpaper.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timewallpaper.presentation.composables.hour.*
import com.example.timewallpaper.presentation.composables.timegroup.Minute
import com.example.timewallpaper.presentation.composables.timegroup.Second
import com.example.timewallpaper.presentation.composables.words.*
import com.example.timewallpaper.domain.state.ScreenTimeState
import com.example.timewallpaper.util.AppThemeState

@Composable
fun TimeComposable(
    state: ScreenTimeState,
    appTheme: AppThemeState = AppThemeState()
) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            It(isActive = state.it)
            Random(text = "L")
            Is(isActive = state.isTime)
            Random(text = "AS")
            Random(text = "AM", isActive = state.am)
            Random(text = "PM", isActive = state.pm)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Random("A", isActive = state.a)
            Random("I")
            Quarter(isActive = state.quarter)
            Random("D")
            Random("C")
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Random(text = "TWENTYFIVE", isActive = state.twenty)
            Random(text = "X")
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Half(isActive = state.half)
            Random(text = "S")
            Ten(isActive = state.ten)
            Random(text = "F")
            To(isActive = state.to)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Past(isActive = state.past)
            Random(text = "ERU")
            Nine(isActive = state.nine)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            One(isActive = state.one)
            Six(isActive = state.six)
            Three(isActive = state.three)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Four(isActive = state.four)
            Five(isActive = state.five)
            Two(isActive = state.two)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Eight(isActive = state.eight)
            Eleven(isActive = state.eleven)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Seven(isActive = state.seven)
            Twelve(isActive = state.twelve)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Random("ZEPII")
            OClock(isActive = state.oClock)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Random(text = "-")
            Minute(isActive = state.minute, minute = state.mValue)
            Random(text = "-")
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Random(text = "---------------")
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Random(text = "-")
            Second(isActive = state.seconds, second = state.sValue)
            Random(text = "-")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TimeComposablePreview() {
    TimeComposable(
        state = ScreenTimeState(),
        appTheme = AppThemeState()
    )
}
