package com.dacoding.easyweather.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.dacoding.easyweather.R

// Set of Material typography styles to start with

private val defaultTypography = Typography()
//val Typography = Typography(
//    body1 = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    )

/* Other default text styles to override
button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
),
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
//)
private val ralewayFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.raleway_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.raleway_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.raleway_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.raleway_semibold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.raleway_italic,
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.raleway_extralight,
            weight = FontWeight.ExtraLight,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.raleway_thin,
            weight = FontWeight.Thin,
            style = FontStyle.Normal
        )
    )
)
val appTypography = Typography(
    h1 = defaultTypography.h1.copy(
        fontFamily = ralewayFamily,
    ),
    h2 = defaultTypography.h2.copy(
        fontFamily = ralewayFamily
    ),
    h3 = defaultTypography.h3.copy(
        fontFamily = ralewayFamily
    ),
    h4 = defaultTypography.h4.copy(
        fontFamily = ralewayFamily
    ),
    h5 = defaultTypography.h5.copy(
        fontFamily = ralewayFamily
    ),
    h6 = defaultTypography.h6.copy(
        fontFamily = ralewayFamily
    ),
    subtitle1 = defaultTypography.subtitle1.copy(
        fontFamily = ralewayFamily
    )
)