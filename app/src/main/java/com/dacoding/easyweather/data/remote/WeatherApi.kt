package com.dacoding.easyweather.data.remote

import com.dacoding.easyweather.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/gfs?&hourly=temperature_2m,relativehumidity_2m,pressure_msl,weathercode,windspeed_10m")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherDto


}

