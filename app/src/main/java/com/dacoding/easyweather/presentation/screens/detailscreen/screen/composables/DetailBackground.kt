package com.dacoding.easyweather.presentation.screens.detailscreen.screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun DetailBackground(
    modifier: Modifier = Modifier,
    imageRes: Int?
) {
    if (imageRes == null) {
        if (isSystemInDarkTheme())
            Box(modifier = Modifier.background(Color.Black))
        else
            Box(modifier = Modifier.background(Color.White))
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