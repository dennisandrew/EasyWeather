package com.dacoding.easyweather.presentation.screens.forecastscreen.screen.util

sealed class ForecastWeatherEvent {
    object Refresh : ForecastWeatherEvent()
}

