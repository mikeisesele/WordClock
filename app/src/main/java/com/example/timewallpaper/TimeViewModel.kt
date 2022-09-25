package com.example.timewallpaper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timescreen.state.DateState
import com.example.timewallpaper.state.ScreenTimeState
import com.example.timewallpaper.state.TimeState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*

class TimeViewModel : ViewModel() {

    private var _timeState: MutableStateFlow<TimeState> = MutableStateFlow(TimeState())
    private val timeState = _timeState.asStateFlow()

    private var _dateState: MutableStateFlow<DateState> = MutableStateFlow(DateState())
    val dateState = _dateState.asStateFlow()

    private val _screenTimeState: MutableStateFlow<ScreenTimeState> = MutableStateFlow(ScreenTimeState())
    val screenTime = _screenTimeState.asStateFlow()

    var hourString = ""
    var minuteString = ""
    var secondString = ""

    fun start() {
        viewModelScope.launch {
            observeTime().collect {
                _screenTimeState.value = it.value
            }
        }
    }

    private fun observeTime() = flow {
        while (true) {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val second = calendar.get(Calendar.SECOND)
            val ampm = calendar.get(Calendar.AM_PM)
            val ampmString = if (ampm == 0) "AM" else "PM"

            convertToWords(hour, minute, second)
            val timeString = "$hour:$minute:$second $ampmString"

            _timeState.value = _timeState.value.copy(
                timeString = timeString,
                hour = hour,
                minute = minute,
                second = second,
                ampm = ampm.toString(),
                hourInWords = hourString,
                minuteInWords = minuteString,
                secondInWords = secondString
            )

            timeState.value.let { timeState ->

                when (timeState.hour.toString()) {
                    "0" -> updateState { state ->
                        state.copy(midnight = true)
                    }
                    "1" -> updateState { state ->
                        state.copy(one = true)
                    }
                    "2" -> updateState { state ->
                        state.copy(two = true)
                    }
                    "3" -> updateState { state ->
                        state.copy(three = true)
                    }
                    "4" -> updateState { state ->
                        state.copy(four = true)
                    }
                    "5" -> updateState { state ->
                        state.copy(five = true)
                    }
                    "6" -> updateState { state ->
                        state.copy(six = true)
                    }
                    "7" -> updateState { state ->
                        state.copy(seven = true)
                    }
                    "8" -> updateState { state ->
                        state.copy(eight = true)
                    }
                    "9" -> updateState { state ->
                        state.copy(nine = true)
                    }
                    "10" -> updateState { state ->
                        state.copy(ten = true)
                    }
                    "11" -> updateState { state ->
                        state.copy(eleven = true)
                    }
                    "12" -> updateState { state ->
                        state.copy(twelve = true)
                    }
                    "13" -> updateState { state ->
                        state.copy(one = true)
                    }
                    "14" -> updateState { state ->
                        state.copy(two = true)
                    }
                    "15" -> updateState { state ->
                        state.copy(three = true)
                    }
                    "16" -> updateState { state ->
                        state.copy(four = true)
                    }
                    "17" -> updateState { state ->
                        state.copy(five = true)
                    }
                    "18" -> updateState { state ->
                        state.copy(six = true)
                    }
                    "19" -> updateState { state ->
                        state.copy(seven = true)
                    }
                    "20" -> updateState { state ->
                        state.copy(eight = true)
                    }
                    "21" -> updateState { state ->
                        state.copy(nine = true)
                    }
                    "22" -> updateState { state ->
                        state.copy(ten = true)
                    }
                    "23" -> updateState { state ->
                        state.copy(eleven = true)
                    }
                    "00" -> updateState { state ->
                        state.copy(twelve = true)
                    }
                }

                when (timeState.minute) {
                    Milestone.EXACT.value -> {
                        updateState { state ->
                            state.copy(oClock = true)
                        }
                    }
                    Milestone.FIFTEEN.value -> {
                        updateState { state ->
                            state.copy(a = true, quarter = true, past = true)
                        }
                        cleanHourAndMinute()
                    }
                    Milestone.THIRTY.value -> {
                        updateState { state ->
                            state.copy(half = true, past = true)
                        }
                        cleanHourAndMinute()
                    }
                    else -> {
                        updateState { state ->
                            state.copy(
                                half = false,
                                quarter = false,
                                to = false,
                                past = false,
                                a = false,
                                hour = true,
                                minute = true,
                                seconds = true,
                                hValue = hourString,
                                mValue = minuteString,
                                sValue = secondString
                            )
                        }
                    }
                }
            }
            emit(_screenTimeState)
            delay(1000)
        }
    }

    private fun cleanHourAndMinute() {
        updateState { state ->
            state.copy(
                hValue = "",
                mValue = "*****",
            )
        }
    }

    private fun convertToWords(hour: Int, minute: Int, second: Int) {
        hourString = when (hour) {
            1 -> "ONE"
            2 -> "TWO"
            3 -> "THREE"
            4 -> "FOUR"
            5 -> "FIVE"
            6 -> "SIX"
            7 -> "SEVEN"
            8 -> "EIGHT"
            9 -> "NINE"
            10 -> "TEN"
            11 -> "ELEVEN"
            12 -> "TWELVE"
            13 -> "ONE"
            14 -> "TWO"
            15 -> "THREE"
            16 -> "FOUR"
            17 -> "FIVE"
            18 -> "SIX"
            19 -> "SEVEN"
            20 -> "EIGHT"
            21 -> "NINE"
            22 -> "TEN"
            23 -> "ELEVEN"
            0 -> "TWELVE"
            else -> ""
        }
        resetScreenTime()
        minuteString = when (minute) {
            1 -> "O' ONE"
            2 -> "O' TWO"
            3 -> "O' THREE"
            4 -> "O' FOUR"
            5 -> "O' FIVE"
            6 -> "O' SIX"
            7 -> "O' SEVEN"
            8 -> "O' EIGHT"
            9 -> "O' NINE"
            10 -> "TEN"
            11 -> "ELEVEN"
            12 -> "TWELVE"
            13 -> "THIRTEEN"
            14 -> "FOURTEEN"
            15 -> "FIFTEEN"
            16 -> "SIXTEEN"
            17 -> "SEVENTEEN"
            18 -> "EIGHTEEN"
            19 -> "NINETEEN"
            20 -> "TWENTY"
            21 -> "TWENTY ONE"
            22 -> "TWENTY TWO"
            23 -> "TWENTY THREE"
            24 -> "TWENTY FOUR"
            25 -> "TWENTY FIVE"
            26 -> "TWENTY SIX"
            27 -> "TWENTY SEVEN"
            28 -> "TWENTY EIGHT"
            29 -> "TWENTY NINE"
            30 -> "THIRTY"
            31 -> "THIRTY ONE"
            32 -> "THIRTY TWO"
            33 -> "THIRTY THREE"
            34 -> "THIRTY FOUR"
            35 -> "THIRTY FIVE"
            36 -> "THIRTY SIX"
            37 -> "THIRTY SEVEN"
            38 -> "THIRTY EIGHT"
            39 -> "THIRTY NINE"
            40 -> "FORTY"
            41 -> "FORTY ONE"
            42 -> "FORTY TWO"
            43 -> "FORTY THREE"
            44 -> "FORTY FOUR"
            45 -> "FORTY FIVE"
            46 -> "FORTY SIX"
            47 -> "FORTY SEVEN"
            48 -> "FORTY EIGHT"
            49 -> "FORTY NINE"
            50 -> "FIFTY"
            51 -> "FIFTY ONE"
            52 -> "FIFTY TWO"
            53 -> "FIFTY THREE"
            54 -> "FIFTY FOUR"
            55 -> "FIFTY FIVE"
            56 -> "FIFTY SIX"
            57 -> "FIFTY SEVEN"
            58 -> "FIFTY EIGHT"
            59 -> "FIFTY NINE"
            60 -> "SIXTY"
            else -> ""
        }

        secondString = when (second) {
            0 -> "one"
            1 -> "two"
            2 -> "three"
            3 -> "four"
            4 -> "five"
            5 -> "six"
            6 -> "seven"
            7 -> "eight"
            8 -> "nine"
            9 -> "ten"
            10 -> "eleven"
            11 -> "twelve"
            12 -> "thirteen"
            13 -> "fourteen"
            14 -> "fifteen"
            15 -> "sixteen"
            16 -> "seventeen"
            17 -> "eighteen"
            18 -> "nineteen"
            19 -> "twenty"
            20 -> "twenty one"
            21 -> "twenty two"
            22 -> "twenty three"
            23 -> "twenty four"
            24 -> "twenty five"
            25 -> "twenty six"
            26 -> "twenty seven"
            27 -> "twenty eight"
            28 -> "twenty nine"
            29 -> "thirty"
            30 -> "thirty one"
            31 -> "thirty two"
            32 -> "thirty three"
            33 -> "thirty four"
            34 -> "thirty five"
            35 -> "thirty six"
            36 -> "thirty seven"
            37 -> "thirty eight"
            38 -> "thirty nine"
            39 -> "forty"
            40 -> "forty one"
            41 -> "forty two"
            42 -> "forty three"
            43 -> "forty four"
            44 -> "forty five"
            45 -> "forty six"
            46 -> "forty seven"
            47 -> "forty eight"
            48 -> "forty nine"
            49 -> "fifty"
            50 -> "fifty one"
            51 -> "fifty two"
            52 -> "fifty three"
            53 -> "fifty four"
            54 -> "fifty five"
            55 -> "fifty six"
            56 -> "fifty seven"
            57 -> "fifty eight"
            58 -> "fifty nine"
            59 -> "sixty"
            else -> ""
        }
    }

    fun observeDate() = flow<String> {
        while (true) {
            val calendar = Calendar.getInstance()
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val year = calendar.get(Calendar.YEAR)
            val dateString = "$month/$day/$year"

            _dateState.value = _dateState.value.copy(
                dateString = dateString,
                month = month.toString(),
                day = day.toString(),
                year = year.toString()
            )

            delay(1000)
        }
    }

    private fun resetScreenTime() {
        updateState { state ->
            state.copy(
                hour = false,
                minute = false,
                seconds = false,
                am = false,
                pm = false,
                one = false,
                two = false,
                three = false,
                four = false,
                five = false,
                six = false,
                seven = false,
                eight = false,
                nine = false,
                ten = false,
                eleven = false,
                twelve = false,
                quarter = false,
                half = false,
                to = false,
                past = false,
                oClock = false,
                fifteen = false,
                twenty = false,
                thirty = false,
                forty = false,
                fifty = false,
                midnight = false,
                a = false,
                hValue = "",
                mValue = "*****",
            )
        }
    }

    private fun updateState(transform: (ScreenTimeState) -> ScreenTimeState) {
        _screenTimeState.update(transform)
    }
}
