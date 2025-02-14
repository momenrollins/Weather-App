package com.momen.weather.utils


object IconProvider {
    fun getIconUrl(iconCode: String): String {
        return "https://openweathermap.org/img/wn/$iconCode@2x.png"
    }
}
