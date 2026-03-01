package com.example.countriesapp.ui.screens.countries

import com.example.countriesapp.domain.model.Country

data class CountriesUiState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val query: String = "",
    val error: String? = null
)