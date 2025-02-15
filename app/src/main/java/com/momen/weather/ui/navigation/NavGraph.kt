package com.momen.weather.ui.navigation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.momen.cityinput.presentation.CityInputScreen
import com.momen.currentweather.presentation.CurrentWeatherScreen
import com.momen.forecast.presentation.ForecastScreen

@Composable
fun NavGraph() {
    Scaffold { innerPadding ->
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "city_input",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("city_input") {
                CityInputScreen(
                    onCitySelected = { city ->
                        navController.navigate("current_weather/$city")
                    }
                )
            }
            composable("current_weather/{city}") { backStackEntry ->
                val city = backStackEntry.arguments?.getString("city") ?: ""
                CurrentWeatherScreen(
                    city = city,
                    onForecastClick = { navController.navigate("forecast/$city") }
                )
            }
            composable("forecast/{city}") { backStackEntry ->
                val city = backStackEntry.arguments?.getString("city") ?: ""
                ForecastScreen(city = city)
            }
        }
    }
}
