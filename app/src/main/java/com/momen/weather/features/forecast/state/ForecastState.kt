package com.momen.weather.features.forecast.state

import com.momen.data.remote.model.ForecastResponse

sealed class ForecastState {
    data object Idle : ForecastState()
    data object Loading : ForecastState()
    data class Success(val forecastResponse: com.momen.data.remote.model.ForecastResponse) : ForecastState()
    data class Error(val error: String) : ForecastState()
}