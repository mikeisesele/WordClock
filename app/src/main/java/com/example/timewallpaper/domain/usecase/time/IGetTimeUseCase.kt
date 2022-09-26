package com.example.timewallpaper.domain.usecase.time

import com.example.timewallpaper.domain.state.ScreenTimeState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface IGetTimeUseCase {
    operator fun invoke(): Flow<MutableStateFlow<ScreenTimeState>>
}
