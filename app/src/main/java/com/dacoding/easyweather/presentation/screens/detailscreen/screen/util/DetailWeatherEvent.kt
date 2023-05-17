package com.dacoding.easyweather.presentation.screens.detailscreen.screen.util

sealed class DetailWeatherEvent {
    object Refresh : DetailWeatherEvent()
}

