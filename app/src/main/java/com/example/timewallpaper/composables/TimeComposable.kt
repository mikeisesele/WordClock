package com.example.timewallpaper.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timewallpaper.composables.hour.Eight
import com.example.timewallpaper.composables.hour.Eleven
import com.example.timewallpaper.composables.hour.Five
import com.example.timewallpaper.composables.hour.Four
import com.example.timewallpaper.composables.hour.Nine
import com.example.timewallpaper.composables.hour.One
import com.example.timewallpaper.composables.hour.Seven
import com.example.timewallpaper.composables.hour.Six
import com.example.timewallpaper.composables.hour.Ten
import com.example.timewallpaper.composables.hour.Three
import com.example.timewallpaper.composables.hour.Twelve
import com.example.timewallpaper.composables.hour.Two
import com.example.timewallpaper.composables.timegroup.Hour
import com.example.timewallpaper.composables.timegroup.Minute
import com.example.timewallpaper.composables.timegroup.Second
import com.example.timewallpaper.composables.words.Half
import com.example.timewallpaper.composables.words.Is
import com.example.timewallpaper.composables.words.It
import com.example.timewallpaper.composables.words.OClock
import com.example.timewallpaper.composables.words.Past
import com.example.timewallpaper.composables.words.Quarter
import com.example.timewallpaper.composables.words.Random
import com.example.timewallpaper.composables.words.To
import com.example.timewallpaper.state.ScreenTimeState

@Composable
fun TimeComposable(
    state: ScreenTimeState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF000000)),
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
    TimeComposable(state = ScreenTimeState())
}
