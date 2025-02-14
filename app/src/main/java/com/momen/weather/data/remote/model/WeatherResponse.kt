package com.momen.weather.data.remote.model


data class WeatherResponse(
    val name: String,
    val main: Main,
    val weather: List<Weather>
) {
    val temp: Double get() = main.temp
    val condition: String get() = weather.firstOrNull()?.main ?: ""
}

data class Main(
    val temp: Double
)

data class Weather(
    val main: String,
    val icon: String
)
