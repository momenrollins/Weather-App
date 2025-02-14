package com.momen.weather.features.cityinput.presentation


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CityInputScreen(
    onCitySelected: (String) -> Unit,
    viewModel: CityInputViewModel = hiltViewModel()
) {
    var cityText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = cityText,
            onValueChange = { cityText = it },
            label = { Text("Enter City Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.setCity(cityText)
                onCitySelected(cityText)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Get Weather")
        }
    }
}
