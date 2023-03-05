package com.dacoding.easyweather.data.remote

import com.dacoding.easyweather.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast?&hourly=temperature_2m,relativehumidity_2m,weathercode,windspeed_10m,pressure_msl")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherDto

    companion object {
        const val BASE_URL = "https://api.open-meteo.com/"
    }
}

