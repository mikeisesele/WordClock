package com.example.timewallpaper.util

import com.example.timewallpaper.presentation.ui.theme.ColorPallet
import com.example.timewallpaper.util.Pref.PREF_MODE
import com.example.timewallpaper.util.Pref.PREF_THEME_COLOR
import java.io.Serializable

data class AppThemeState(
    var darkTheme: Boolean = getSharedPrefInstance().getBooleanValue(PREF_MODE),
    var pallet: ColorPallet = ColorPallet.valueOf(getSharedPrefInstance().getStringValue(PREF_THEME_COLOR, "BLUE"))
) : Serializable
