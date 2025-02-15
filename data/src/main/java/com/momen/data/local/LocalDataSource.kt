package com.momen.data.local

interface LocalDataSource {
    fun getLastSearchedCity(): String?
    fun saveLastSearchedCity(city: String)
}