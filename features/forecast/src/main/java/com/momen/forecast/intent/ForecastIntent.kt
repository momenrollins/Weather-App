package com.momen.forecast.intent

sealed class ForecastIntent {
    data class LoadForecast(val city: String) : ForecastIntent()
}
