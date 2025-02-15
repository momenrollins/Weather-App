package com.momen.weatherutils


import java.text.SimpleDateFormat
import java.util.*

object WeatherFormatter {

    fun formatTemperature(temp: Double): String {
        return String.format(Locale.US,"%.1f°C", temp)
    }

    fun formatDate(timestamp: Long): String {
        val date = Date(timestamp * 1000)
        val format = SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault())
        return format.format(date)
    }
}
