package com.dacoding.easyweather.presentation.screens.detailscreen.screen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.presentation.screens.detailscreen.screen.util.DetailWeatherState

@Composable
fun WeatherDetailForecast(
    state: DetailWeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxHeight(),
                content = {
                    item {
                        LabelColumn()
                    }
                    items(data) { weatherData ->
                        DetailWeatherDisplay(
                            weatherData = weatherData,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                        )
                    }
                },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
        }
    }
}