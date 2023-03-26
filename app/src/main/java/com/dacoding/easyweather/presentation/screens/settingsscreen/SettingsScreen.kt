package com.dacoding.easyweather.presentation.screens.settingsscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.presentation.WeatherViewModel
import com.dacoding.easyweather.presentation.screens.homescreen.screen.composables.elements.Background
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme
import com.dacoding.easyweather.presentation.util.getImageResByWeatherType

@Composable
fun SettingsScreen(
    viewModel: WeatherViewModel
) {
    EasyWeatherTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Background(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(16.dp),
                imageRes = getImageResByWeatherType(viewModel.state.weatherInfo)
            )
            Text(text = "Settings Screen")
        }
    }
}