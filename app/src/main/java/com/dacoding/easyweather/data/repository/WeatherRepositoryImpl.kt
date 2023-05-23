package com.dacoding.easyweather.data.repository

import com.dacoding.easyweather.R
import com.dacoding.easyweather.data.mappers.toWeatherInfo
import com.dacoding.easyweather.data.remote.WeatherApi
import com.dacoding.easyweather.domain.repository.WeatherRepository
import com.dacoding.easyweather.domain.util.Resource
import com.dacoding.easyweather.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getHourlyWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: R.string.unknown_error.toString())
        }

    }
}