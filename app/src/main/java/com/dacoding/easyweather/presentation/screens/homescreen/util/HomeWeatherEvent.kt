package com.dacoding.easyweather.presentation.screens.homescreen.util

sealed class HomeWeatherEvent {
    object Refresh: HomeWeatherEvent()
}
