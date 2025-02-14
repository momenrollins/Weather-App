package com.momen.weather.features.cityinput.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CityInputViewModel @Inject constructor() : ViewModel() {
    private val _city = MutableLiveData("")
    val city: LiveData<String> = _city

    fun setCity(city: String) {
        _city.value = city
    }
}
