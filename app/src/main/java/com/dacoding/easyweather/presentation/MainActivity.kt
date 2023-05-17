package com.dacoding.easyweather.presentation

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dacoding.easyweather.presentation.navigation.NavigationDrawer
import com.dacoding.easyweather.presentation.screens.detailscreen.screen.util.DetailWeatherViewModel
import com.dacoding.easyweather.presentation.screens.homescreen.screen.util.HomeWeatherViewModel
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeWeatherViewModel by viewModels()
    private val detailViewModel: DetailWeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    private lateinit var navController: NavHostController
    val gpsSettingsIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            homeViewModel.loadWeatherInfo()
            detailViewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
        setContent {
            EasyWeatherTheme {
                navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavigationDrawer(
                        navController = navController, homeViewModel = homeViewModel,
                        detailViewModel = detailViewModel
                    )
                }
            }
        }

    }

}




