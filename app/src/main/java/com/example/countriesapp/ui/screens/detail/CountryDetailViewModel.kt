package com.example.countriesapp.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapp.data.repository.CountriesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountryDetailViewModel(
    private val repository: CountriesRepository = CountriesRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(CountryDetailUiState(isLoading = true))
    val uiState: StateFlow<CountryDetailUiState> = _uiState.asStateFlow()

    fun load(code: String) {
        viewModelScope.launch {
            _uiState.value = CountryDetailUiState(isLoading = true)
            try {
                val country = repository.getCountryDetail(code)
                _uiState.value = CountryDetailUiState(
                    isLoading = false,
                    country = country,
                    error = if (country == null) "No se encontró el país" else null
                )
            } catch (e: Exception) {
                _uiState.value = CountryDetailUiState(
                    isLoading = false,
                    error = e.message ?: "Error al cargar detalle"
                )
            }
        }
    }
}