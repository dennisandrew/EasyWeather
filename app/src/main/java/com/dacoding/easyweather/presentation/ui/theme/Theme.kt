package com.dacoding.easyweather.presentation.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = darkColors(
    primary = TextUniversal,
    background = BackgroundLight,
    onBackground = TextLight,
    primaryVariant = Grey
)

private val DarkColorPalette = darkColors(
    primary = TextUniversal,
    background = BackgroundDark,
    onBackground = TextDark,
    primaryVariant = Grey
)

@Composable
fun EasyWeatherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = appTypography,
        shapes = Shapes,
        content = content
    )
}