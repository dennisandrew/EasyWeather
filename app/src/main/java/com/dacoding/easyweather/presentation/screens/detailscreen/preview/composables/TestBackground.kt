package com.dacoding.easyweather.presentation.screens.detailscreen.preview.composables

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dacoding.easyweather.R
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme


@Composable
fun TestBackground(
    modifier: Modifier = Modifier,
    imageRes: Int?
) {
    if (imageRes == null) {
        if (isSystemInDarkTheme())
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black))
        else
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White))
    } else {
        Image(
            modifier = modifier,
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix()
                    .apply {
                        setToScale(
                            0.75f,
                            0.75f,
                            0.75f,
                            1f
                        )
                    }
            )
        )
    }
}

@Preview(showBackground = true,
    backgroundColor = 0x000000,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TestBackgroundPreview() {
    EasyWeatherTheme {
        TestBackground(imageRes = R.drawable.weather_clear)
    }
}


