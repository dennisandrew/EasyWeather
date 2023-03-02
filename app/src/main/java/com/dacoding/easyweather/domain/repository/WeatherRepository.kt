package com.dacoding.easyweather.domain.repository

import com.dacoding.easyweather.domain.util.Resource
import com.dacoding.easyweather.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}