package com.dacoding.easyweather.presentation.screens.homescreen.screen.composables.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.domain.weather.WeatherData
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colors.primary
) {
    val formattedTime = remember(weatherData) {
        val timePattern = "HH:mm"
        weatherData.time.format(
            DateTimeFormatter.ofPattern(timePattern)
        )
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = formattedTime,
            color = textColor,
            style = MaterialTheme.typography.button
        )
        Box(
            modifier = Modifier.size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = weatherData.weatherType.iconRes),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }
        Text(
            text = when (weatherData.temperatureCelsius > 0) {
                true -> "+${weatherData.temperatureCelsius.roundToInt()}°"
                false -> if (weatherData.temperatureCelsius.roundToInt() == 0) {
                    " ${weatherData.temperatureCelsius.roundToInt()}°"
                } else {
                    "${weatherData.temperatureCelsius.roundToInt()}°"
                }
            },
            color = textColor,
            style = MaterialTheme.typography.button
        )
    }
}
