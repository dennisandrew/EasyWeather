package com.dacoding.easyweather.presentation.screens.homescreen.screen.composables.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.presentation.screens.homescreen.screen.util.HomeWeatherState

@Composable
fun WeatherHourlyForecast(
    state: HomeWeatherState,
    modifier: Modifier = Modifier
) {
//    val textColor = MaterialTheme.colors.onBackground
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Text(
//                text = stringResource(id = R.string.weather_today),
//                fontSize = 16.sp,
//                color = textColor
//            )
//            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(content = {
                items(data) { weatherData ->
                    HourlyWeatherDisplay(
                        weatherData = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            })
        }
    }
}
