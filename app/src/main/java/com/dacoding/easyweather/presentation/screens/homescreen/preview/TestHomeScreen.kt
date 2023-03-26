package com.dacoding.easyweather.presentation.screens.homescreen.preview

import android.content.Intent
import android.widget.Toast
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.dacoding.easyweather.App
import com.dacoding.easyweather.R
import com.dacoding.easyweather.presentation.MainActivity
import com.dacoding.easyweather.presentation.screens.homescreen.preview.composables.TestBackground
import com.dacoding.easyweather.presentation.screens.homescreen.preview.composables.TestBottomSheet
import com.dacoding.easyweather.presentation.screens.homescreen.preview.composables.TestWeatherBlock
import com.dacoding.easyweather.presentation.screens.homescreen.preview.util.TestHomeWeatherState
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme
import com.dacoding.easyweather.presentation.util.UiText
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun TestHomeScreen() {
    val state = TestHomeWeatherState()
    val isRefreshing = state.isRefreshing
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isRefreshing)
    EasyWeatherTheme {
        SwipeRefresh(
            modifier = Modifier.fillMaxSize(),
            state = swipeRefreshState,
            onRefresh = { Toast(App.applicationContext()).setText("Refresh") }) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillParentMaxHeight(1f)
                    ) {
                        TestBackground(
                            modifier = Modifier.fillMaxSize(),
                            imageRes = R.drawable.weather_clear
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            TestWeatherBlock(
                                state = state,
                            )
                            TestBottomSheet(state)
                        }

                        if (state.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center),
                                color = MaterialTheme.colors.primaryVariant,
                                strokeWidth = 2.dp
                            )
                        }
                        state.error?.let { error ->
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
                                    onClick = { Toast(App.applicationContext()).setText("Refresh") },
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


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EasyWeatherTheme {
        TestHomeScreen()
    }
}




