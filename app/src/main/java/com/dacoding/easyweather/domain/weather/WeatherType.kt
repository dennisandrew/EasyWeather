package com.dacoding.easyweather.domain.weather

import androidx.annotation.DrawableRes
import com.dacoding.easyweather.App
import com.dacoding.easyweather.R
import com.dacoding.easyweather.presentation.util.UiText

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherType(
        weatherDesc = UiText.StringResource(R.string.clear_sky).asString(App.applicationContext()),
        iconRes = R.drawable.ic_sunny
    )

    object MainlyClear : WeatherType(
        weatherDesc = UiText.StringResource(R.string.mainly_clear)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_sunnycloudy
    )

    object PartlyCloudy : WeatherType(
        weatherDesc = UiText.StringResource(R.string.partly_cloudy)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_cloudy
    )

    object Overcast : WeatherType(
        weatherDesc = UiText.StringResource(R.string.overcast).asString(App.applicationContext()),
        iconRes = R.drawable.ic_cloudy
    )

    object Foggy : WeatherType(
        weatherDesc = UiText.StringResource(R.string.foggy).asString(App.applicationContext()),
        iconRes = R.drawable.ic_very_cloudy
    )

    object DepositingRimeFog : WeatherType(
        weatherDesc = UiText.StringResource(R.string.depositing_rime_fog)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_very_cloudy
    )

    object LightDrizzle : WeatherType(
        weatherDesc = UiText.StringResource(R.string.light_drizzle)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_rainshower
    )

    object ModerateDrizzle : WeatherType(
        weatherDesc = UiText.StringResource(R.string.moderate_drizzle)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_rainshower
    )

    object DenseDrizzle : WeatherType(
        weatherDesc = UiText.StringResource(R.string.dense_drizzle)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_rainshower
    )

    object LightFreezingDrizzle : WeatherType(
        weatherDesc = UiText.StringResource(R.string.slight_freezing_drizzle)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_snowyrainy
    )

    object DenseFreezingDrizzle : WeatherType(
        weatherDesc = UiText.StringResource(R.string.dense_freezing_drizzle)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_snowyrainy
    )

    object SlightRain : WeatherType(
        weatherDesc = UiText.StringResource(R.string.slight_rain)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_rainy
    )

    object ModerateRain : WeatherType(
        weatherDesc = UiText.StringResource(R.string.moderate_rain)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_rainy
    )

    object HeavyRain : WeatherType(
        weatherDesc = UiText.StringResource(R.string.heavy_rain).asString(App.applicationContext()),
        iconRes = R.drawable.ic_rainy
    )

    object LightFreezingRain : WeatherType(
        weatherDesc = UiText.StringResource(R.string.light_freezing_rain)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_snowyrainy
    )

    object HeavyFreezingRain : WeatherType(
        weatherDesc = UiText.StringResource(R.string.heavy_freezing_rain)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_snowyrainy
    )

    object SlightSnowFall : WeatherType(
        weatherDesc = UiText.StringResource(R.string.slight_snow_fall)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_snowy
    )

    object ModerateSnowFall : WeatherType(
        weatherDesc = UiText.StringResource(R.string.moderate_snow_fall)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_heavysnow
    )

    object HeavySnowFall : WeatherType(
        weatherDesc = UiText.StringResource(R.string.heavy_snow_fall)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_heavysnow
    )

    object SnowGrains : WeatherType(
        weatherDesc = UiText.StringResource(R.string.snow_grains)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_heavysnow
    )

    object SlightRainShowers : WeatherType(
        weatherDesc = UiText.StringResource(R.string.slight_rain_showers)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_rainshower
    )

    object ModerateRainShowers : WeatherType(
        weatherDesc = UiText.StringResource(R.string.moderate_rain_showers)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_rainshower
    )

    object ViolentRainShowers : WeatherType(
        weatherDesc = UiText.StringResource(R.string.violent_rain_showers)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_rainshower
    )

    object SlightSnowShowers : WeatherType(
        weatherDesc = UiText.StringResource(R.string.slight_snow_showers)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_snowy
    )

    object HeavySnowShowers : WeatherType(
        weatherDesc = UiText.StringResource(R.string.heavy_snow_showers)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_snowy
    )

    object ModerateThunderstorm : WeatherType(
        weatherDesc = UiText.StringResource(R.string.moderate_thunderstorm)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_thunder
    )

    object SlightHailThunderstorm : WeatherType(
        weatherDesc = UiText.StringResource(R.string.thunderstorm_with_slight_hail)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_rainythunder
    )

    object HeavyHailThunderstorm : WeatherType(
        weatherDesc = UiText.StringResource(R.string.thunderstorm_with_heavy_hail)
            .asString(App.applicationContext()),
        iconRes = R.drawable.ic_rainythunder
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingRain
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}