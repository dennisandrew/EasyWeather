package com.dacoding.easyweather.presentation.screens.detailscreen.preview

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.App
import com.dacoding.easyweather.R
import com.dacoding.easyweather.presentation.screens.detailscreen.preview.composables.TestDetailTempChart
import com.dacoding.easyweather.presentation.screens.detailscreen.preview.util.TestDetailWeatherState
import com.dacoding.easyweather.presentation.screens.homescreen.preview.composables.TestBackground
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun TestDetailScreen() {
    val state = TestDetailWeatherState()
    val isRefreshing = state.isRefreshing
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isRefreshing)
    EasyWeatherTheme {
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = { Toast(App.applicationContext()).setText("Refresh") }) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Box(
                        modifier = Modifier.fillParentMaxHeight(1f)
                    ) {
                        TestBackground(
                            modifier = Modifier
                                .blur(16.dp)
                                .fillMaxSize(),
                            imageRes = R.drawable.weather_clear
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(32.dp),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            TestDetailTempChart()
                        }
                    }
                }
            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun TestDetailScreenPreview() {
    EasyWeatherTheme {
        TestDetailScreen()
    }
}
