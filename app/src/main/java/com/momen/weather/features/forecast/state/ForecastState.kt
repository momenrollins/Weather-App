package com.momen.weather.features.forecast.state

import com.momen.weather.data.remote.model.ForecastResponse

sealed class ForecastState {
    data object Idle : ForecastState()
    data object Loading : ForecastState()
    data class Success(val forecastResponse: ForecastResponse) : ForecastState()
    data class Error(val error: String) : ForecastState()
}