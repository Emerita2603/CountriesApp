package com.example.countriesapp.ui.screens.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapp.data.repository.CountriesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val repository: CountriesRepository = CountriesRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(CountriesUiState(isLoading = true))
    val uiState: StateFlow<CountriesUiState> = _uiState.asStateFlow()

    init {
        loadCountries()
    }

    fun loadCountries() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            try {
                val countries = repository.getCountries()
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    countries = countries
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Error al cargar países"
                )
            }
        }
    }

    fun onQueryChange(text: String) {
        _uiState.value = _uiState.value.copy(query = text)

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            try {
                val result = repository.searchCountries(text)
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    countries = result
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Error en búsqueda"
                )
            }
        }
    }
}