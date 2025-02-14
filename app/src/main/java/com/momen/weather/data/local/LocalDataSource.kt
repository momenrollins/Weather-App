package com.momen.weather.data.local

interface LocalDataSource {
    fun getLastSearchedCity(): String?
    fun saveLastSearchedCity(city: String)
}