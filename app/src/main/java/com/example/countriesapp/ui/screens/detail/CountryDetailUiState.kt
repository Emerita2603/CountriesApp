package com.example.countriesapp.ui.screens.detail

import com.example.countriesapp.domain.model.Country

data class CountryDetailUiState(
    val isLoading: Boolean = false,
    val country: Country? = null,
    val error: String? = null
)