package com.dacoding.easyweather.presentation.util

import com.dacoding.easyweather.R
import com.dacoding.easyweather.domain.weather.WeatherInfo
import com.dacoding.easyweather.domain.weather.WeatherType

fun getImageResByWeatherType(weatherInfo: WeatherInfo?): Int? {
    return when (weatherInfo?.currentWeatherData?.weatherType) {
        is WeatherType.MainlyClear ->
            R.drawable.weather_mainly_clear
        is WeatherType.PartlyCloudy ->
            R.drawable.weather_partly_cloudy
        is WeatherType.Overcast ->
            R.drawable.weather_overcast
        is WeatherType.Foggy ->
            R.drawable.weather_foggy
        is WeatherType.DepositingRimeFog ->
            R.drawable.weather_depositing_rime_fog
        is WeatherType.LightDrizzle ->
            R.drawable.weather_light_drizzle
        is WeatherType.ModerateDrizzle ->
            R.drawable.weather_moderate_drizzle
        is WeatherType.DenseDrizzle ->
            R.drawable.weather_dense_drizzle
        is WeatherType.LightFreezingDrizzle ->
            R.drawable.weather_light_freezing_drizzle
        is WeatherType.DenseFreezingDrizzle ->
            R.drawable.weather_dense_freezing_drizzle
        is WeatherType.SlightRain ->
            R.drawable.weather_slight_rain
        is WeatherType.ModerateRain ->
            R.drawable.weather_moderate_rain
        is WeatherType.HeavyRain ->
            R.drawable.weather_heavy_rain
        is WeatherType.LightFreezingRain ->
            R.drawable.weather_light_freezing_rain
        is WeatherType.HeavyFreezingRain ->
            R.drawable.weather_heavy_freezing_rain
        is WeatherType.SlightSnowFall ->
            R.drawable.weather_slight_snow_fall
        is WeatherType.ModerateSnowFall ->
            R.drawable.weather_moderate_snow_fall
        is WeatherType.HeavySnowFall ->
            R.drawable.weather_heavy_snow_fall
        is WeatherType.SnowGrains ->
            R.drawable.weather_snow_grains
        is WeatherType.SlightRainShowers ->
            R.drawable.weather_slight_rain_showers
        is WeatherType.ModerateRainShowers ->
            R.drawable.weather_moderate_rain_showers
        is WeatherType.ViolentRainShowers ->
            R.drawable.weather_violent_rain_showers
        is WeatherType.SlightSnowShowers ->
            R.drawable.weather_slight_snow_showers
        is WeatherType.HeavySnowShowers ->
            R.drawable.weather_heavy_snow_showers
        is WeatherType.ModerateThunderstorm ->
            R.drawable.weather_moderate_thunderstorm
        is WeatherType.SlightHailThunderstorm ->
            R.drawable.weather_slight_hail_thunderstorm
        is WeatherType.HeavyHailThunderstorm ->
            R.drawable.weather_heavy_hail_thunderstorm
        null -> null
        else -> R.drawable.weather_clear
    }
}