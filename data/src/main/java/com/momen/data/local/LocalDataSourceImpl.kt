package com.momen.data.local


import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSourceImpl @Inject constructor(context: Context) : LocalDataSource {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("weather_prefs", Context.MODE_PRIVATE)

    override fun getLastSearchedCity(): String? =
        prefs.getString("last_searched_city", null)

    override fun saveLastSearchedCity(city: String) {
        prefs.edit().putString("last_searched_city", city).apply()
    }
}
