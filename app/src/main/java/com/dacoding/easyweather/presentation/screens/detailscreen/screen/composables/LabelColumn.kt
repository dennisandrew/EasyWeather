package com.dacoding.easyweather.presentation.screens.detailscreen.screen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.R

@Composable
fun LabelColumn() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 16.dp, top = 148.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(56.dp)
    ) {

        val labelHeight = 36

        Box(
            modifier = Modifier
                .size(height = labelHeight.dp, width = 150.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.temperature),
                style = MaterialTheme.typography.caption
            )
        }

        Box(
            modifier = Modifier.size(height = labelHeight.dp, width = 150.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.pressure),
                style = MaterialTheme.typography.caption
            )
        }

        Box(
            modifier = Modifier.size(height = labelHeight.dp, width = 150.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.humidity),
                style = MaterialTheme.typography.caption
            )
        }

        Box(
            modifier = Modifier.size(height = labelHeight.dp, width = 150.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.wind_speed),
                style = MaterialTheme.typography.caption
            )
        }

        Box(
            modifier = Modifier.size(height = labelHeight.dp, width = 150.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.precipitation_rate),
                style = MaterialTheme.typography.caption
            )
        }

        Box(
            modifier = Modifier.size(height = labelHeight.dp, width = 150.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.cloud_coverage),
                style = MaterialTheme.typography.caption
            )
        }
    }
}
