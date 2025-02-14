package com.momen.weather.features.currentweather.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.rememberAsyncImagePainter
import com.momen.weather.utils.IconProvider

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        weather?.let {
            Text(text = "City: ${it.name}", style = MaterialTheme.typography.titleLarge)
            Text(text = "Temperature: ${it.temp}°C", style = MaterialTheme.typography.titleMedium)
            Text(text = "Condition: ${it.condition}", style = MaterialTheme.typography.bodyLarge)

            // Example of displaying the weather icon using Coil and our custom IconProvider:
            it.weather.firstOrNull()?.let { weatherItem ->
                val iconUrl = IconProvider.getIconUrl(weatherItem.icon)
                Image(
                    painter = rememberAsyncImagePainter(iconUrl),
                    contentDescription = "Weather Icon",
                    modifier = Modifier.size(64.dp)
                )
            }
        } ?: Text("Loading weather...", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onForecastClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View 7-Day Forecast")
        }
    }
}
