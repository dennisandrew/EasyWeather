package com.dacoding.easyweather.data.mappers

import com.dacoding.easyweather.data.remote.dto.HourlyWeatherDataDto
import com.dacoding.easyweather.data.remote.dto.HourlyWeatherDto
import com.dacoding.easyweather.domain.weather.WeatherData
import com.dacoding.easyweather.domain.weather.WeatherInfo
import com.dacoding.easyweather.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun HourlyWeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        val apparentTemperature = apparentTemperatures[index]
        val currentPrecipitations = precipitations[index]
        val currentCloudCover = cloudCover[index]
        val currentWindGusts = windGusts[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode),
                apparentTemperature = apparentTemperature,
                currentPrecipitations = currentPrecipitations,
                currentCloudCover = currentCloudCover,
                currentWindGusts = currentWindGusts
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

fun HourlyWeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = when {
            now.minute < 30 -> now.hour
            now.hour == 23 -> 0
            else -> now.hour + 1
        }
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}

