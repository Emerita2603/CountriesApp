package com.example.countriesapp.ui.screens.countries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.countriesapp.ui.components.CountryCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountriesScreen(
    onCountryClick: (String) -> Unit,
    vm: CountriesViewModel = viewModel()
) {
    val state by vm.uiState.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("CountriesApp") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(12.dp)
        ) {
            TextField(
                value = state.query,
                onValueChange = { vm.onQueryChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                placeholder = { Text("Buscar país...") }
            )

            Text("Mostrando ${state.countries.size} países")

            when {
                state.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
                }

                state.error != null -> {
                    Text(
                        text = state.error ?: "Error",
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }

                else -> {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(top = 12.dp, bottom = 12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(state.countries) { country ->
                            CountryCard(country = country, onClick = onCountryClick)
                        }
                    }
                }
            }
        }
    }
}