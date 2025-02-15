package com.momen.data.remote

import com.momen.data.remote.model.ForecastResponse
import com.momen.data.remote.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): WeatherResponse

    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("cnt") days: Int = 7
    ): ForecastResponse
}
