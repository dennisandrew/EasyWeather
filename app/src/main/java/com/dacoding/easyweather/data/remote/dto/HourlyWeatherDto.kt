package com.dacoding.easyweather.data.remote.dto

import com.squareup.moshi.Json

data class HourlyWeatherDto(
    @field:Json(name = "hourly")
    val weatherData: HourlyWeatherDataDto
)
