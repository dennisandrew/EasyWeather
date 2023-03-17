package com.dacoding.easyweather.presentation.screens.homescreen.composables.elements

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


@Composable
fun Background(
    modifier: Modifier = Modifier,
    imageRes: Int
) {
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


