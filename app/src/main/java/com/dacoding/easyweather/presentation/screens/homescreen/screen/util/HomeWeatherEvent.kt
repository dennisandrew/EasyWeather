package com.dacoding.easyweather.presentation.screens.homescreen.screen.util

sealed class HomeWeatherEvent {
    object Refresh: HomeWeatherEvent()
}
