package com.momen.weather.features.currentweather.presentation


import androidx.lifecycle.*
import com.momen.data.remote.model.WeatherResponse
import com.momen.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val repository: com.momen.data.repository.WeatherRepository
) : ViewModel() {
    private val _weather = MutableLiveData<com.momen.data.remote.model.WeatherResponse?>()
    val weather: LiveData<com.momen.data.remote.model.WeatherResponse?> = _weather

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun loadWeather(city: String) {
        viewModelScope.launch {
            try {
                _weather.value = repository.getCurrentWeather(city)
                _error.value = null
            } catch (e: Exception) {
                _weather.value = null
                _error.value = "Failed to load weather: ${e.localizedMessage}"
            }
        }
    }
}
