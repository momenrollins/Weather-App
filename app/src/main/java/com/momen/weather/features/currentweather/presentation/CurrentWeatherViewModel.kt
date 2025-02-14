package com.momen.weather.features.currentweather.presentation


import androidx.lifecycle.*
import com.momen.weather.data.remote.model.WeatherResponse
import com.momen.weather.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val _weather = MutableLiveData<WeatherResponse?>()
    val weather: LiveData<WeatherResponse?> = _weather

    fun loadWeather(city: String) {
        viewModelScope.launch {
            try {
                _weather.value = repository.getCurrentWeather(city)
            } catch (e: Exception) {
                _weather.value = null
            }
        }
    }
}
