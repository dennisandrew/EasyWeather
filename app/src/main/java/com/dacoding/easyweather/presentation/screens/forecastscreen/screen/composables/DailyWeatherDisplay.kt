package com.dacoding.easyweather.presentation.screens.forecastscreen.screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dacoding.easyweather.App
import com.dacoding.easyweather.R
import com.dacoding.easyweather.domain.weather.WeatherData
import com.dacoding.easyweather.domain.weather.WeatherType
import com.dacoding.easyweather.presentation.util.UiText
import java.time.LocalDate
import kotlin.math.roundToInt

@Composable
fun DailyWeatherDisplay(
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colors.primary,
    weatherData: Pair<Int, List<WeatherData>>
) {
    weatherData.second.let { data ->
        val dayIndex = data[0].time.dayOfWeek
        val temperatures = mutableListOf<Double>()
        val tempAverage: Double?
        val weatherTypes = mutableListOf<WeatherType>()
        val weatherAverage: WeatherType?

        data.forEach { weatherData ->
            temperatures.add(weatherData.temperatureCelsius)
        }
        data.forEach { weatherData ->
            weatherTypes.add(weatherData.weatherType)
        }

        tempAverage = temperatures.average()
        weatherAverage = weatherTypes.groupingBy { it }.eachCount().maxBy { it.value }.key

        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = toDayOfWeek(dayIndex.value),
                    style = MaterialTheme.typography.button,
                    color = textColor,
                    fontSize = 12.sp
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = weatherAverage.iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(42.dp)
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = when (tempAverage > 0) {
                        true -> "+${tempAverage.roundToInt()}°"
                        false -> if (tempAverage.roundToInt() == 0) {
                            " ${tempAverage.roundToInt()}°"
                        } else {
                            "${tempAverage.roundToInt()}°"
                        }
                    },
                    color = textColor,
                    style = MaterialTheme.typography.button,
                    fontSize = 22.sp
                )
            }
        }
    }
}

fun toDayOfWeek(index: Int): String {
    return when (index) {
        LocalDate.now().dayOfWeek.value -> {
            UiText.StringResource(R.string.today).asString(App.applicationContext()).uppercase()
        }

        else -> {
            return when (index) {
                2 -> UiText.StringResource(R.string.day_tuesday).asString(App.applicationContext())
                    .uppercase()

                3 -> UiText.StringResource(R.string.day_wednesday)
                    .asString(App.applicationContext())
                    .uppercase()

                4 -> UiText.StringResource(R.string.day_thursday).asString(App.applicationContext())
                    .uppercase()

                5 -> UiText.StringResource(R.string.day_friday).asString(App.applicationContext())
                    .uppercase()

                6 -> UiText.StringResource(R.string.day_saturday).asString(App.applicationContext())
                    .uppercase()

                7 -> UiText.StringResource(R.string.day_sunday).asString(App.applicationContext())
                    .uppercase()

                else -> UiText.StringResource(R.string.day_monday)
                    .asString(App.applicationContext())
                    .uppercase()
            }
        }
    }
}
