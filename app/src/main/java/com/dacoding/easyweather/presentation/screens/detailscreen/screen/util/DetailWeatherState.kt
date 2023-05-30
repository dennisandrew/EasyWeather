package com.dacoding.easyweather.presentation.screens.detailscreen.screen.util

import com.dacoding.easyweather.domain.weather.WeatherInfo

data class DetailWeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRefreshing: Boolean = false,
)
