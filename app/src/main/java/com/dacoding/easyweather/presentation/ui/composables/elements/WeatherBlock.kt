package com.dacoding.easyweather.presentation.ui.composables.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dacoding.easyweather.R
import com.dacoding.easyweather.presentation.WeatherState
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.roundToInt

@Composable
fun WeatherBlock(
    modifier: Modifier = Modifier,
    state: WeatherState,
) {
    val timePattern = "HH:mm"
    val textColor = MaterialTheme.colors.onBackground
    state.weatherInfo?.currentWeatherData?.let { data ->
        Box(
            modifier = modifier
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${stringResource(id = R.string.today)} ${
                        data.time.format(
                            DateTimeFormatter.ofPattern(timePattern)
                        )
                    }",
                    modifier = Modifier
                        .padding(top = 46.dp)
                        .align(Alignment.End),
                    color = textColor
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "${data.temperatureCelsius.roundToInt()}°",
                    fontSize = 86.sp,
                    color = textColor,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier,
                    text = data.weatherType.weatherDesc,
                    fontSize = 20.sp,
                    color = textColor
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    if (Locale.getDefault().country != "RU") {
                        WeatherDataDisplay(
                            value = data.pressure.roundToInt(),
                            unit = stringResource(id = R.string.hpa),
                            icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                            iconTint = textColor,
                            textStyle = TextStyle(color = textColor)
                        )
                    } else {
                        WeatherDataDisplay(
                            value = (data.pressure * 0.750062).roundToInt(),
                            unit = stringResource(id = R.string.hpa),
                            icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                            iconTint = textColor,
                            textStyle = TextStyle(color = textColor)
                        )
                    }
                    WeatherDataDisplay(
                        value = data.humidity.roundToInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                        iconTint = textColor,
                        textStyle = TextStyle(color = textColor)
                    )
                    WeatherDataDisplay(
                        value = data.windSpeed.roundToInt(),
                        unit = stringResource(id = R.string.km_per_h),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                        iconTint = textColor,
                        textStyle = TextStyle(color = textColor)
                    )
                }
            }
        }
    }
}

