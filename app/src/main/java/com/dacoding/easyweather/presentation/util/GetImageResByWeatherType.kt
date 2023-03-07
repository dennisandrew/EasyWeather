package com.dacoding.easyweather.presentation.util

import com.dacoding.easyweather.R
import com.dacoding.easyweather.domain.weather.WeatherInfo
import com.dacoding.easyweather.domain.weather.WeatherType

fun getImageResByWeatherType(weatherInfo: WeatherInfo?): Int {
    val pictureRes: Int
    when (weatherInfo?.currentWeatherData?.weatherType) {
        is WeatherType.MainlyClear -> pictureRes = R.drawable.weather_clear_mainly
        is WeatherType.PartlyCloudy -> pictureRes = R.drawable.weather_cloudy_partly
        is WeatherType.Overcast -> pictureRes = R.drawable.weather_overcast
        is WeatherType.Foggy -> pictureRes = R.drawable.weather_foggy_slight
        is WeatherType.DepositingRimeFog -> pictureRes = R.drawable.weather_freezing
        is WeatherType.LightDrizzle -> pictureRes = R.drawable.weather_rain
        is WeatherType.ModerateDrizzle -> pictureRes = R.drawable.weather_rain
        is WeatherType.DenseDrizzle -> pictureRes = R.drawable.weather_rain
        is WeatherType.LightFreezingDrizzle -> pictureRes = R.drawable.weather_rain
        is WeatherType.DenseFreezingDrizzle -> pictureRes = R.drawable.weather_rain
        is WeatherType.SlightRain -> pictureRes = R.drawable.weather_rain
        is WeatherType.ModerateRain -> pictureRes = R.drawable.weather_rain
        is WeatherType.HeavyRain -> pictureRes = R.drawable.weather_heavy_rain
        is WeatherType.LightFreezingRain -> pictureRes = R.drawable.weather_rain
        is WeatherType.HeavyFreezingRain -> pictureRes = R.drawable.weather_rain
        is WeatherType.SlightSnowFall -> pictureRes = R.drawable.weather_snow_slight
        is WeatherType.ModerateSnowFall -> pictureRes = R.drawable.weather_snow_moderate
        is WeatherType.HeavySnowFall -> pictureRes = R.drawable.weather_snow_moderate
        is WeatherType.SnowGrains -> pictureRes = R.drawable.weather_snow_slight
        is WeatherType.SlightRainShowers -> pictureRes = R.drawable.weather_heavy_rain
        is WeatherType.ModerateRainShowers -> pictureRes = R.drawable.weather_heavy_rain
        is WeatherType.ViolentRainShowers -> pictureRes = R.drawable.weather_heavy_rain
        is WeatherType.SlightSnowShowers -> pictureRes = R.drawable.weather_snow_moderate
        is WeatherType.HeavySnowShowers -> pictureRes = R.drawable.weather_snow_moderate
        is WeatherType.ModerateThunderstorm -> pictureRes = R.drawable.weather_heavy_rain
        is WeatherType.SlightHailThunderstorm -> pictureRes = R.drawable.weather_heavy_rain
        is WeatherType.HeavyHailThunderstorm -> pictureRes = R.drawable.weather_heavy_rain
        else -> pictureRes = R.drawable.weather_heavy_rain
    }
    return pictureRes
}