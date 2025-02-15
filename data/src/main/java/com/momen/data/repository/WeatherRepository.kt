package com.momen.data.repository

import com.momen.data.remote.model.ForecastResponse
import com.momen.data.remote.model.WeatherResponse

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String): WeatherResponse
    suspend fun getForecast(city: String): ForecastResponse
}
