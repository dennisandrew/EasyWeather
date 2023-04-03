package com.dacoding.easyweather.presentation.screens.homescreen.preview.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dacoding.easyweather.R
import com.dacoding.easyweather.presentation.screens.homescreen.preview.util.TestHomeWeatherState
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.roundToInt

@Composable
fun TestWeatherBlock(
    state: TestHomeWeatherState,
) {
    val timePattern = "HH:mm"
    val textColor = MaterialTheme.colors.primary
    state.weatherInfo?.currentWeatherData?.let { data ->
        Box {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${stringResource(id = R.string.today)} ${
                        data.time.format(
                            DateTimeFormatter.ofPattern(timePattern)
                        )
                    }",
                    modifier = Modifier
                        .align(Alignment.End),
                    color = textColor,
                    style = MaterialTheme.typography.body2
                )
                Spacer(modifier = Modifier.height(46.dp))
                Text(
                    text = when (data.temperatureCelsius > 0) {
                        true -> "+${data.temperatureCelsius.roundToInt()}°"
                        false -> if (data.temperatureCelsius.roundToInt() == 0) {
                            " ${data.temperatureCelsius.roundToInt()}°"
                        } else {
                            "${data.temperatureCelsius.roundToInt()}°"
                        }
                    },
                    fontSize = 86.sp,
                    color = textColor,
                    style = MaterialTheme.typography.body2
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    modifier = Modifier,
                    text = "Clear sky",
                    fontSize = 20.sp,
                    color = textColor,
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(48.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    if (Locale.getDefault().country != "RU") {
                        TestWeatherDataDisplay(
                            // Value in hpa
                            value = data.pressure.roundToInt(),
                            unit = stringResource(id = R.string.hpa),
                            icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                            iconTint = textColor,
                            textStyle = MaterialTheme.typography.caption
                        )
                    } else {
                        TestWeatherDataDisplay(
                            // Value in mm Hg
                            value = (data.pressure * 0.750062).roundToInt(),
                            unit = stringResource(id = R.string.hpa),
                            icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                            iconTint = textColor,
                            textStyle = MaterialTheme.typography.caption
                        )
                    }
                    TestWeatherDataDisplay(
                        value = data.humidity.roundToInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                        iconTint = textColor,
                        textStyle = MaterialTheme.typography.caption
                    )
                    TestWeatherDataDisplay(
                        value = data.windSpeed.roundToInt(),
                        unit = stringResource(id = R.string.km_per_h),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                        iconTint = textColor,
                        textStyle = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun TestWeatherBlockPreview() {
    EasyWeatherTheme {
        TestWeatherBlock(state = TestHomeWeatherState())
    }
}

