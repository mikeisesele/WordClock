package com.example.timewallpaper.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timewallpaper.domain.state.ScreenTimeState
import com.example.timewallpaper.domain.usecase.time.IGetTimeUseCase
import com.example.timewallpaper.util.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TimeViewModel @Inject constructor(
    private val getTimeUseCase: IGetTimeUseCase
) : ViewModel() {

    private val _screenTimeState: MutableStateFlow<ScreenTimeState> = MutableStateFlow(ScreenTimeState())
    val screenTime = _screenTimeState.asStateFlow()

    fun startTime() {
        viewModelScope.launch {
            getTimeUseCase.invoke().collect {
                _screenTimeState.value = it.value
                it.value.dateState.log()
            }
        }
    }
}
