package com.dacoding.easyweather.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dacoding.easyweather.presentation.WeatherViewModel
import com.dacoding.easyweather.presentation.screens.homescreen.HomeScreen
import com.dacoding.easyweather.presentation.screens.settingsscreen.SettingsScreen

@Composable
fun EasyWeatherNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String = "home",
    viewModel: WeatherViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable("home") {
            HomeScreen(viewModel = viewModel)
        }
        composable("settings") {
            SettingsScreen(viewModel = viewModel)
        }
    }

}