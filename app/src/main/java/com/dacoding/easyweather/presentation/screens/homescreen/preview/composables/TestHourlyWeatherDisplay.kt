package com.dacoding.easyweather.presentation.screens.homescreen.preview.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.R
import com.dacoding.easyweather.domain.test.TestWeatherData
import com.dacoding.easyweather.presentation.screens.homescreen.preview.util.TestHomeWeatherState
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun TestHourlyWeatherDisplay(
    weatherData: TestWeatherData,
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
            color = textColor
        )
        Image(
            painter = painterResource(id = R.drawable.ic_cloudy),
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )
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
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun TestHourlyWeatherDisplayPreview() {
    EasyWeatherTheme {
       TestHourlyWeatherDisplay(weatherData = TestHomeWeatherState().weatherInfo?.currentWeatherData!!)
    }
}