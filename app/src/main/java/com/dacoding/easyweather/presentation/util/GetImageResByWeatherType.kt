package com.dacoding.easyweather.presentation.util

import com.dacoding.easyweather.R
import com.dacoding.easyweather.domain.weather.WeatherInfo
import com.dacoding.easyweather.domain.weather.WeatherType

fun getImageResByWeatherType(weatherInfo: WeatherInfo?): Int {
    val pictureRes: Int
    when (weatherInfo?.currentWeatherData?.weatherType) {
        is WeatherType.MainlyClear -> pictureRes = R.drawable.weather_mainly_clear
        is WeatherType.PartlyCloudy -> pictureRes = R.drawable.weather_partly_cloudy
        is WeatherType.Overcast -> pictureRes = R.drawable.weather_overcast
        is WeatherType.Foggy -> pictureRes = R.drawable.weather_foggy
        is WeatherType.DepositingRimeFog -> pictureRes = R.drawable.weather_depositing_rime_fog
        is WeatherType.LightDrizzle -> pictureRes = R.drawable.weather_light_drizzle
        is WeatherType.ModerateDrizzle -> pictureRes = R.drawable.weather_moderate_drizzle
        is WeatherType.DenseDrizzle -> pictureRes = R.drawable.weather_dense_drizzle
        is WeatherType.LightFreezingDrizzle -> pictureRes =
            R.drawable.weather_light_freezing_drizzle
        is WeatherType.DenseFreezingDrizzle -> pictureRes =
            R.drawable.weather_dense_freezing_drizzle
        is WeatherType.SlightRain -> pictureRes = R.drawable.weather_slight_rain
        is WeatherType.ModerateRain -> pictureRes = R.drawable.weather_moderate_rain
        is WeatherType.HeavyRain -> pictureRes = R.drawable.weather_heavy_rain
        is WeatherType.LightFreezingRain -> pictureRes = R.drawable.weather_light_freezing_rain
        is WeatherType.HeavyFreezingRain -> pictureRes = R.drawable.weather_heavy_freezing_rain
        is WeatherType.SlightSnowFall -> pictureRes = R.drawable.weather_slight_snow_fall
        is WeatherType.ModerateSnowFall -> pictureRes = R.drawable.weather_moderate_snow_fall
        is WeatherType.HeavySnowFall -> pictureRes = R.drawable.weather_heavy_snow_fall
        is WeatherType.SnowGrains -> pictureRes = R.drawable.weather_snow_grains
        is WeatherType.SlightRainShowers -> pictureRes = R.drawable.weather_slight_rain_showers
        is WeatherType.ModerateRainShowers -> pictureRes = R.drawable.weather_moderate_rain_showers
        is WeatherType.ViolentRainShowers -> pictureRes = R.drawable.weather_violent_rain_showers
        is WeatherType.SlightSnowShowers -> pictureRes = R.drawable.weather_slight_snow_showers
        is WeatherType.HeavySnowShowers -> pictureRes = R.drawable.weather_heavy_snow_showers
        is WeatherType.ModerateThunderstorm -> pictureRes = R.drawable.weather_moderate_thunderstorm
        is WeatherType.SlightHailThunderstorm -> pictureRes =
            R.drawable.weather_slight_hail_thunderstorm
        is WeatherType.HeavyHailThunderstorm -> pictureRes =
            R.drawable.weather_heavy_hail_thunderstorm
        null -> pictureRes = R.drawable.background_on_start
        else -> pictureRes = R.drawable.weather_clear
    }
    return pictureRes
}