package com.dacoding.easyweather.presentation.screens.forecastscreen.screen.util

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dacoding.easyweather.App
import com.dacoding.easyweather.R
import com.dacoding.easyweather.domain.location.LocationTracker
import com.dacoding.easyweather.domain.repository.WeatherRepository
import com.dacoding.easyweather.domain.util.Resource
import com.dacoding.easyweather.presentation.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastWeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
) : ViewModel() {
    var state by mutableStateOf(ForecastWeatherState())
        private set

    fun onEvent(forecastWeatherEvent: ForecastWeatherEvent) {
        when (forecastWeatherEvent) {
            is ForecastWeatherEvent.Refresh -> {
                loadWeatherInfo()
            }
        }
    }

    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                when (
                    val result = repository.getWeatherData(location.latitude, location.longitude)
                ) {
                    is Resource.Success -> {
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null,
                        )
                        Log.d("DEBUGLOC", "Location is: ${location.longitude} ${location.latitude}")
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = UiText.StringResource(R.string.gps_error).asString(
                        App.applicationContext()
                    )
                )
            }
        }
    }
}
