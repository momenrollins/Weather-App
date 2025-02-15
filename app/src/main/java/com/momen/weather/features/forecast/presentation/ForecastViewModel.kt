package com.momen.weather.features.forecast.presentation


import androidx.lifecycle.*
import com.momen.data.repository.WeatherRepository
import com.momen.weather.features.forecast.intent.ForecastIntent
import com.momen.weather.features.forecast.state.ForecastState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val repository: com.momen.data.repository.WeatherRepository
) : ViewModel() {

    private val _state = MutableLiveData<ForecastState>(ForecastState.Idle)
    val state: LiveData<ForecastState> = _state

    fun processIntent(intent: ForecastIntent) {
        when(intent) {
            is ForecastIntent.LoadForecast -> loadForecast(intent.city)
        }
    }

    private fun loadForecast(city: String) {
        viewModelScope.launch {
            _state.value = ForecastState.Loading
            try {
                val response = repository.getForecast(city)
                _state.value = ForecastState.Success(response)
            } catch (e: Exception) {
                _state.value = ForecastState.Error(e.localizedMessage ?: "Unknown Error")
            }
        }
    }
}
