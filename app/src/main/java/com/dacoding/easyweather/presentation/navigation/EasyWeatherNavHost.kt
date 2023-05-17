package com.dacoding.easyweather.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dacoding.easyweather.presentation.screens.detailscreen.screen.DetailScreen
import com.dacoding.easyweather.presentation.screens.detailscreen.screen.util.DetailWeatherViewModel
import com.dacoding.easyweather.presentation.screens.homescreen.screen.HomeScreen
import com.dacoding.easyweather.presentation.screens.homescreen.screen.util.HomeWeatherViewModel

@Composable
fun EasyWeatherNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String = "home",
    homeViewModel: HomeWeatherViewModel,
    detailViewModel: DetailWeatherViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable("home") {
            HomeScreen(viewModel = homeViewModel)
        }
//        composable("settings") {
//            SettingsScreen(viewModel = viewModel)
//        }
        composable("detail") {
            DetailScreen(viewModel = detailViewModel)
        }
    }

}