package com.dacoding.easyweather.domain.test

data class TestWeatherData(
    val time: String,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: String
)
