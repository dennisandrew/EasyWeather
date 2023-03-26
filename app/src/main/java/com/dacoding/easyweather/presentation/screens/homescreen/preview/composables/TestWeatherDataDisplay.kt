package com.dacoding.easyweather.presentation.screens.homescreen.preview.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.R
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme

@Composable
fun TestWeatherDataDisplay(
    value: Int,
    unit: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    iconTint: Color = MaterialTheme.colors.primary
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "$value $unit",
            style = textStyle
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun TestWeatherDataDisplayPreview() {
    EasyWeatherTheme {
        TestWeatherDataDisplay(
            value = 15,
            unit = "%" ,
            icon = ImageVector
                .vectorResource(
                id = R.drawable.ic_drop
            ),
            textStyle = TextStyle(color = MaterialTheme.colors.primary)
        )

    }
}