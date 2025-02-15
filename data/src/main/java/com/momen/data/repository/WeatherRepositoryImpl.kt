package com.momen.data.repository

import com.momen.data.BuildConfig
import com.momen.data.local.LocalDataSource
import com.momen.data.remote.WeatherApi
import com.momen.data.remote.model.ForecastResponse
import com.momen.data.remote.model.WeatherResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private val localDataSource: LocalDataSource
) : WeatherRepository {
    private val API_KEY = BuildConfig.API_KEY

    override suspend fun getCurrentWeather(city: String): WeatherResponse {
        localDataSource.saveLastSearchedCity(city)
        return api.getCurrentWeather(city, API_KEY)
    }

    override suspend fun getForecast(city: String): ForecastResponse {
        localDataSource.saveLastSearchedCity(city)
        return api.getForecast(city, API_KEY)
    }
}
