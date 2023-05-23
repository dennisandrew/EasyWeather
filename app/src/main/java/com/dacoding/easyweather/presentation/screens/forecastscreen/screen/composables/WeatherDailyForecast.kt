package com.dacoding.easyweather.presentation.screens.forecastscreen.screen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.presentation.screens.forecastscreen.screen.util.ForecastWeatherState

@Composable
fun WeatherDailyForecast(
    modifier: Modifier = Modifier,
    state: ForecastWeatherState
) {
    state.weatherInfo?.weatherDataPerDay?.toList().let { data ->
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            data?.forEach { weatherData ->
                DailyWeatherDisplay(
                    weatherData = weatherData,
                    modifier = Modifier
                        .height(100.dp)
                )
            }
        }
    }
}