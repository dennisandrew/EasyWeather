package com.dacoding.easyweather.presentation.ui.composables.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


@Composable
fun Background(imageRes: Int) {
    Image(
        modifier = Modifier.fillMaxSize(),
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


