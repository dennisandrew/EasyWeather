package com.dacoding.easyweather.domain.test

data class TestWeatherInfo(
    val weatherDataPerDay: Map<Int, List<TestWeatherData>>,
    val currentWeatherData: TestWeatherData?
)
