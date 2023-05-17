package com.dacoding.easyweather.presentation.screens.detailscreen.preview.composables

import android.graphics.Color
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme
import com.patrykandpatrick.vico.compose.axis.horizontal.bottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.startAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.compose.m3.style.m3ChartStyle
import com.patrykandpatrick.vico.compose.style.ProvideChartStyle
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.component.shape.Shapes
import com.patrykandpatrick.vico.core.entry.entryModelOf
import kotlin.math.roundToInt


@Composable
fun TestDetailTempChart() {
    val chartEntry = entryModelOf(4f, 2f, 6f, 7f, 8f, 9f, 11f)
    ProvideChartStyle(
        chartStyle = m3ChartStyle(
            axisLabelColor = MaterialTheme.colors.primary,
            axisGuidelineColor = MaterialTheme.colors.primary,
            axisLineColor = MaterialTheme.colors.primary,
            entityColors = listOf(MaterialTheme.colors.primary),
        )
    ) {
        Chart(
            modifier = Modifier
                .height(128.dp)
                .padding(8.dp)
                .alpha(0.85f),
            isZoomEnabled = false,

            chart = columnChart(
                columns = listOf(
                    LineComponent(
                        color = MaterialTheme.colors.primary.toArgb(),
                        shape = Shapes.pillShape,
                        thicknessDp = 8f
                    )
                )
            ),
            model = chartEntry,
            startAxis = startAxis(
                guideline = LineComponent(
                    color = MaterialTheme.colors.primary.toArgb(),
                    thicknessDp = 0.35f,
                    strokeWidthDp = 0.15f,
                    strokeColor = Color.TRANSPARENT
                ),
                valueFormatter = { value, chartValues ->
                    chartValues.chartEntryModel.entries.first().getOrNull(value.toInt())
                        .run { "${value.roundToInt()}°C" }
                }
            ),
            bottomAxis = bottomAxis(

                guideline = null,
                valueFormatter = { value, chartValues ->
                    chartValues.chartEntryModel.entries.first().getOrNull(value.toInt())
                        .run { "${value.toInt()}:00" }
                }
            )
        )
    }
}


@Preview(showBackground = false)
@Composable
fun TestChartPreview() {
    EasyWeatherTheme {
        TestDetailTempChart()
    }
}
