package com.momen.forecast.presentation


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.momen.forecast.intent.ForecastIntent
import com.momen.forecast.state.ForecastState
import com.momen.core.utils.WeatherFormatter

@Composable
fun ForecastScreen(
    city: String,
    viewModel: ForecastViewModel = hiltViewModel()
) {
    LaunchedEffect(city) {
        viewModel.processIntent(ForecastIntent.LoadForecast(city))
    }

    val state by viewModel.state.observeAsState(initial = ForecastState.Idle)

    when (state) {
        ForecastState.Idle, ForecastState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is ForecastState.Success -> {
            val forecastResponse = (state as ForecastState.Success).forecastResponse
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(forecastResponse.list) { forecast ->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Date: ${WeatherFormatter.formatDate(forecast.dt)}",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = "Temperature: ${forecast.main.temp}°C",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = "Condition: ${forecast.weather.firstOrNull()?.main ?: "N/A"}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
        is ForecastState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Error: ${(state as ForecastState.Error).error}")
            }
        }
    }
}
