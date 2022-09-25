package com.example.timewallpaper.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.example.timewallpaper.util.TextColor.textPrimaryDarkColor
import com.example.timewallpaper.util.TextColor.textPrimaryLightColor
import com.example.timewallpaper.util.TextColor.textSecondaryDarkColor
import com.example.timewallpaper.util.TextColor.textSecondaryLightColor

@SuppressLint("ConflictingOnColor")
private val DarkGreenColorPalette = darkColors(
    primary = appGreenColor,
    primaryVariant = appGreenColor,
    onPrimary = textPrimaryDarkColor,
    onSecondary = textSecondaryDarkColor,
    onBackground = cardBackgroundBlackDark,
    secondary = cardBackgroundBlackDark,
    background = scaffoldDarkBlackDark
)

@SuppressLint("ConflictingOnColor")
private val DarkPurpleColorPalette = darkColors(
    primary = appPurpleColor,
    primaryVariant = appPurpleColor,
    onPrimary = textPrimaryDarkColor,
    onSecondary = textSecondaryDarkColor,
    onBackground = cardBackgroundBlackDark,
    secondary = cardBackgroundBlackDark,
    background = scaffoldDarkBlackDark
)

@SuppressLint("ConflictingOnColor")
private val DarkBlueColorPalette = darkColors(
    primary = appBlueColor,
    primaryVariant = appBlueColor,
    onPrimary = textPrimaryDarkColor,
    onSecondary = textSecondaryDarkColor,
    onBackground = cardBackgroundBlackDark,
    secondary = cardBackgroundBlackDark,
    background = scaffoldDarkBlackDark
)

@SuppressLint("ConflictingOnColor")
private val DarkOrangeColorPalette = darkColors(
    primary = appOrangeColor,
    primaryVariant = appOrangeColor,
    onPrimary = textPrimaryDarkColor,
    onSecondary = textSecondaryDarkColor,
    onBackground = cardBackgroundBlackDark,
    secondary = cardBackgroundBlackDark,
    background = scaffoldDarkBlackDark
)

@SuppressLint("ConflictingOnColor")
private val DarkRedColorPalette = darkColors(
    primary = appRedColor,
    primaryVariant = appRedColor,
    onPrimary = textPrimaryDarkColor,
    onSecondary = textSecondaryDarkColor,
    onBackground = cardBackgroundBlackDark,
    secondary = cardBackgroundBlackDark,
    background = scaffoldDarkBlackDark
)

@SuppressLint("ConflictingOnColor")
private val DarkPinkColorPalette = darkColors(
    primary = appPinkColor,
    primaryVariant = appPinkColor,
    onPrimary = textPrimaryDarkColor,
    onSecondary = textSecondaryDarkColor,
    onBackground = cardBackgroundBlackDark,
    secondary = cardBackgroundBlackDark,
    background = scaffoldDarkBlackDark
)

@SuppressLint("ConflictingOnColor")
private val DarkYellowColorPalette = darkColors(
    primary = appYellowColor,
    primaryVariant = appYellowColor,
    onPrimary = textPrimaryDarkColor,
    onSecondary = textSecondaryDarkColor,
    onBackground = cardBackgroundBlackDark,
    secondary = cardBackgroundBlackDark,
    background = scaffoldDarkBlackDark
)

// Light pallets
@SuppressLint("ConflictingOnColor")
private val LightGreenColorPalette = lightColors(
    primary = appGreenColor,
    onPrimary = textPrimaryLightColor,
    onSecondary = textSecondaryLightColor,
    onBackground = appBackgroundColor,
    secondary = appLightGreyColor,
    background = appScaffoldColor
)

@SuppressLint("ConflictingOnColor")
private val LightPurpleColorPalette = lightColors(
    primary = appPurpleColor,
    onPrimary = textPrimaryLightColor,
    onSecondary = textSecondaryLightColor,
    onBackground = appBackgroundColor,
    secondary = appLightGreyColor,
    background = appScaffoldColor
)

@SuppressLint("ConflictingOnColor")
private val LightBlueColorPalette = lightColors(
    primary = appBlueColor,
    onPrimary = textPrimaryLightColor,
    onSecondary = textSecondaryLightColor,
    onBackground = appBackgroundColor,
    secondary = appLightGreyColor,
    background = appScaffoldColor
)

@SuppressLint("ConflictingOnColor")
private val LightOrangeColorPalette = lightColors(
    primary = appOrangeColor,
    onPrimary = textPrimaryLightColor,
    onSecondary = textSecondaryLightColor,
    onBackground = appBackgroundColor,
    secondary = appLightGreyColor,
    background = appScaffoldColor
)

@SuppressLint("ConflictingOnColor")
private val LightRedColorPalette = lightColors(
    primary = appRedColor,
    onPrimary = textPrimaryLightColor,
    onSecondary = textSecondaryLightColor,
    onBackground = appBackgroundColor,
    secondary = appLightGreyColor,
    background = appScaffoldColor

)

@SuppressLint("ConflictingOnColor")
private val LightPinkColorPalette = lightColors(
    primary = appPinkColor,
    onPrimary = textPrimaryLightColor,
    onSecondary = textSecondaryLightColor,
    onBackground = appBackgroundColor,
    secondary = appLightGreyColor,
    background = appScaffoldColor
)

@SuppressLint("ConflictingOnColor")
private val LightYellowColorPalette = lightColors(
    primary = appYellowColor,
    onPrimary = textPrimaryLightColor,
    onSecondary = textSecondaryLightColor,
    onBackground = appBackgroundColor,
    secondary = appLightGreyColor,
    background = appScaffoldColor
)

enum class ColorPallet {
    RED, PURPLE, GREEN, ORANGE, BLUE, YELLOW, PINK
}

@Composable
fun ClockWallPaperTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorPallet: ColorPallet = ColorPallet.BLUE,
    content: @Composable () -> Unit,
) {
    val colors = when (colorPallet) {
        ColorPallet.GREEN -> if (darkTheme) DarkGreenColorPalette else LightGreenColorPalette
        ColorPallet.PURPLE -> if (darkTheme) DarkPurpleColorPalette else LightPurpleColorPalette
        ColorPallet.ORANGE -> if (darkTheme) DarkOrangeColorPalette else LightOrangeColorPalette
        ColorPallet.BLUE -> if (darkTheme) DarkBlueColorPalette else LightBlueColorPalette
        ColorPallet.RED -> if (darkTheme) DarkRedColorPalette else LightRedColorPalette
        ColorPallet.YELLOW -> if (darkTheme) DarkYellowColorPalette else LightYellowColorPalette
        ColorPallet.PINK -> if (darkTheme) DarkPinkColorPalette else LightPinkColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
