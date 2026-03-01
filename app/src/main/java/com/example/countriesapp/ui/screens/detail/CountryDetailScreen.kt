package com.example.countriesapp.ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun CountryDetailScreen(
    code: String,
    onBack: () -> Unit,
    vm: CountryDetailViewModel = viewModel()
) {
    val state by vm.uiState.collectAsState()

    LaunchedEffect(code) {
        vm.load(code)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = onBack) { Text("Volver") }

        when {
            state.isLoading -> CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))

            state.error != null -> Text(
                text = state.error ?: "Error",
                modifier = Modifier.padding(top = 16.dp)
            )

            state.country != null -> {
                val c = state.country!!

                AsyncImage(
                    model = c.flagUrl,
                    contentDescription = "Bandera de ${c.name}",
                    modifier = Modifier.padding(top = 16.dp)
                )

                Text(text = "Nombre: ${c.name}", modifier = Modifier.padding(top = 12.dp))
                Text(text = "Oficial: ${c.officialName}")
                Text(text = "Capital: ${c.capital}")
                Text(text = "Región: ${c.region}")
                Text(text = "Subregión: ${c.subregion}")
                Text(text = "Población: ${c.population}")

                val langs = if (c.languages.isEmpty()) "No disponible" else c.languages.joinToString()
                Text(text = "Idiomas: $langs")
            }
        }
    }
}