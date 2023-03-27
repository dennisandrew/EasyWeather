package com.dacoding.easyweather.presentation.screens.homescreen.preview.util

import com.dacoding.easyweather.domain.test.TestWeatherData
import com.dacoding.easyweather.domain.test.TestWeatherInfo

data class TestHomeWeatherState(
    val weatherInfo: TestWeatherInfo? =
        TestWeatherInfo(
            currentWeatherData = TestWeatherData(
                time = "4:20",
                temperatureCelsius = 0.0,
                pressure = 0.0,
                windSpeed = 0.0,
                humidity = 0.0,
                weatherType = "Clear"
            ),
            weatherDataPerDay = mapOf(
                Pair(
                    0,
                    List(30) {
                        TestWeatherData(
                            time = "4:20",
                            temperatureCelsius = 0.0,
                            pressure = 0.0,
                            windSpeed = 0.0,
                            humidity = 0.0,
                            weatherType = "Clear"
                        )
                    }
                )
            )
        ),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRefreshing: Boolean = false,
)
