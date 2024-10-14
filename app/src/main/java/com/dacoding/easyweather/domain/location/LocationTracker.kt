package com.dacoding.easyweather.domain.location

import android.content.Context
import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
    fun getCityName(context: Context, location: Location): String?
}
