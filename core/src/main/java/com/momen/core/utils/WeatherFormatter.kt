package com.momen.core.utils


import java.text.SimpleDateFormat
import java.util.*

object WeatherFormatter {
    fun formatDate(timestamp: Long): String {
        val date = Date(timestamp * 1000)
        val format = SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault())
        return format.format(date)
    }
}
