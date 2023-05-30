package com.dacoding.easyweather.presentation.screens.detailscreen.screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dacoding.easyweather.App
import com.dacoding.easyweather.R
import com.dacoding.easyweather.domain.weather.WeatherData
import com.dacoding.easyweather.presentation.util.UiText
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun DetailWeatherDisplay(
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
        Spacer(modifier = Modifier.height(36.dp))
        Box(
            modifier = Modifier.size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = weatherData.weatherType.iconRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
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
        Spacer(modifier = Modifier.height(36.dp))
        Box(
            modifier = Modifier.size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_pressure),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = "${weatherData.pressure} ${
                UiText.StringResource(R.string.hpa).asString(App.applicationContext())
            }",
            color = textColor,
            style = MaterialTheme.typography.button,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(36.dp))
        Box(
            modifier = Modifier.size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_drop),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = "${weatherData.humidity} %",
            color = textColor,
            style = MaterialTheme.typography.button,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(36.dp))
        Box(
            modifier = Modifier.size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_wind),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = "${weatherData.windSpeed} ${
                UiText.StringResource(R.string.km_per_h).asString(App.applicationContext())
            }",
            color = textColor,
            style = MaterialTheme.typography.button,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(36.dp))
        Box(
            modifier = Modifier.size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_ruler),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = "${weatherData.currentPrecipitations} ${
                UiText.StringResource(R.string.mm).asString(App.applicationContext())
            }",
            color = textColor,
            style = MaterialTheme.typography.button,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(36.dp))
        Box(
            modifier = Modifier.size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_shadow),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = "${weatherData.currentCloudCover} %",
            color = textColor,
            style = MaterialTheme.typography.button,
            fontSize = 12.sp
        )
    }
}