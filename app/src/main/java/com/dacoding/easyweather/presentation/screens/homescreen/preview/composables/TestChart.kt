package com.dacoding.easyweather.presentation.screens.homescreen.preview.composables

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme
import com.patrykandpatrick.vico.compose.axis.horizontal.bottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.startAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.m3.style.m3ChartStyle
import com.patrykandpatrick.vico.compose.style.ProvideChartStyle
import com.patrykandpatrick.vico.core.entry.entryModelOf


@Composable
fun TestChart() {
    val chartEntry = entryModelOf(4f, 2f, 6f, 7f)

    ProvideChartStyle(
        chartStyle = m3ChartStyle(
            axisLabelColor = MaterialTheme.colors.primary,
            axisGuidelineColor = MaterialTheme.colors.primary,
            axisLineColor = MaterialTheme.colors.primary,
            entityColors = listOf(MaterialTheme.colors.primary),
        )
    ) {
        Chart(
            chart = lineChart(),
            model = chartEntry,
            startAxis = startAxis(),
            bottomAxis = bottomAxis()
        )
    }
}


@Preview(showBackground = false)
@Composable
fun TestChartPreview() {
    EasyWeatherTheme {
        TestChart()
    }
}
