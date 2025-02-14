package com.momen.weather.data.remote.model

data class ForecastResponse(
    val list: List<Forecast>
)

data class Forecast(
    val dt: Long,
    val main: Main,
    val weather: List<Weather>
)
