package com.momen.weather.data.repository

import com.momen.weather.data.remote.model.ForecastResponse
import com.momen.weather.data.remote.model.WeatherResponse

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String): WeatherResponse
    suspend fun getForecast(city: String): ForecastResponse
}
