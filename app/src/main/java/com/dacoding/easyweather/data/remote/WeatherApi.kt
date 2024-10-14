package com.dacoding.easyweather.data.remote

import com.dacoding.easyweather.data.remote.dto.HourlyWeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(
        "v1/gem?hourly=temperature_2m," +
                "relativehumidity_2m," +
                "apparent_temperature," +
                "precipitation," +
                "weathercode," +
                "pressure_msl," +
                "cloudcover," +
                "windspeed_10m," +
                "windgusts_10m"
    )
    suspend fun getHourlyWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): HourlyWeatherDto
}
