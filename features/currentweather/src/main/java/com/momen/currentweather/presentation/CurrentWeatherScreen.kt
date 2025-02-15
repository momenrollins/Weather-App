package com.momen.currentweather.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.rememberAsyncImagePainter
import com.momen.core.utils.IconProvider

@Composable
fun CurrentWeatherScreen(
    city: String,
    onForecastClick: () -> Unit,
    viewModel: CurrentWeatherViewModel = hiltViewModel()
) {
    LaunchedEffect(city) {
        viewModel.loadWeather(city)
    }

    val weather = viewModel.weather.observeAsState().value
    val error = viewModel.error.observeAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        when {
            error != null -> {
                Text(text = error, color = Color.Red, style = MaterialTheme.typography.bodyLarge)
            }

            weather != null -> {
                Text(text = "City: ${weather.name}", style = MaterialTheme.typography.titleLarge)
                Text(
                    text = "Temperature: ${weather.temp}°C",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Condition: ${weather.condition}",
                    style = MaterialTheme.typography.bodyLarge
                )

                weather.weather.firstOrNull()?.let { weatherItem ->
                    val iconUrl = IconProvider.getIconUrl(weatherItem.icon)
                    Image(
                        painter = rememberAsyncImagePainter(iconUrl),
                        contentDescription = "Weather Icon",
                        modifier = Modifier.size(64.dp)
                    )
                }
            }

            else -> {
                Text("Loading weather...", style = MaterialTheme.typography.bodyLarge)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onForecastClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View 7-Day Forecast")
        }
    }
}
