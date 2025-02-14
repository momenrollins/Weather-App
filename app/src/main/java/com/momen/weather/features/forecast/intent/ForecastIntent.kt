package com.momen.weather.features.forecast.intent

sealed class ForecastIntent {
    data class LoadForecast(val city: String) : ForecastIntent()
}
