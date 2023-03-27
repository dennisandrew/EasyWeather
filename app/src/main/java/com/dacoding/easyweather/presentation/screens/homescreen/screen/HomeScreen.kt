package com.dacoding.easyweather.presentation.screens.homescreen

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.dacoding.easyweather.App
import com.dacoding.easyweather.R
import com.dacoding.easyweather.presentation.MainActivity
import com.dacoding.easyweather.presentation.WeatherViewModel
import com.dacoding.easyweather.presentation.screens.homescreen.screen.composables.elements.Background
import com.dacoding.easyweather.presentation.screens.homescreen.screen.composables.elements.BottomSheet
import com.dacoding.easyweather.presentation.screens.homescreen.screen.composables.elements.WeatherBlock
import com.dacoding.easyweather.presentation.screens.homescreen.screen.util.HomeWeatherEvent
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme
import com.dacoding.easyweather.presentation.util.UiText
import com.dacoding.easyweather.presentation.util.getImageResByWeatherType
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun HomeScreen(
    viewModel: WeatherViewModel,
) {
    val isRefreshing = viewModel.state.isRefreshing
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isRefreshing)
    EasyWeatherTheme {
        SwipeRefresh(
            modifier = Modifier.fillMaxSize(),
            state = swipeRefreshState,
            onRefresh = { viewModel.onEvent(HomeWeatherEvent.Refresh) }) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillParentMaxHeight(1f)
                    ) {
                        Background(
                            modifier = Modifier.fillMaxSize(),
                            imageRes = getImageResByWeatherType(
                                viewModel.state.weatherInfo
                            )
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            WeatherBlock(
                                state = viewModel.state,
                            )
                            if (viewModel.state.weatherInfo?.weatherDataPerDay?.isEmpty() == false)
                                BottomSheet(viewModel = viewModel)
                        }

                        if (viewModel.state.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center),
                                color = MaterialTheme.colors.primaryVariant,
                                strokeWidth = 2.dp
                            )
                        }
                        viewModel.state.error?.let { error ->
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = error,
                                    color = MaterialTheme.colors.onBackground,
                                    textAlign = TextAlign.Center,
                                )
                                IconButton(
                                    onClick = { viewModel.loadWeatherInfo() },
                                    modifier = Modifier
                                        .size(48.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Refresh,
                                        contentDescription = null,
                                        tint = MaterialTheme.colors.onBackground
                                    )
                                }
                                Box(
                                    Modifier.clickable {
                                        ContextCompat.startActivity(
                                            App.applicationContext(),
                                            MainActivity()
                                                .gpsSettingsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK),
                                            null
                                        )
                                    }
                                ) {
                                    Text(
                                        modifier = Modifier.padding(8.dp),
                                        text = UiText.StringResource(R.string.to_gps_settings_btn)
                                            .asString(
                                                App.applicationContext()
                                            ),
                                        color = MaterialTheme.colors.onBackground
                                    )
                                }
                            }
                        }
                    }
                }

            }

        }

    }
}