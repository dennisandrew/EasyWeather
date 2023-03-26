package com.dacoding.easyweather.presentation.screens.homescreen.screen.util

import com.dacoding.easyweather.domain.weather.WeatherInfo

data class HomeWeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRefreshing: Boolean = false,
)
