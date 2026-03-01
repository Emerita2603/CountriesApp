package com.example.countriesapp.data.repository

import com.example.countriesapp.data.remote.RetrofitClient
import com.example.countriesapp.data.remote.dto.CountryDto
import com.example.countriesapp.domain.model.Country

class CountriesRepository {

    private val api = RetrofitClient.api
    private var cache: List<Country> = emptyList()

    suspend fun getCountries(forceRemote: Boolean = false): List<Country> {
        if (cache.isNotEmpty() && !forceRemote) return cache

        val dto = api.getAllCountries()
        val mapped = dto.mapNotNull { it.toDomainOrNull() }
            .sortedBy { it.name.lowercase() }

        cache = mapped
        return mapped
    }

    suspend fun searchCountries(query: String): List<Country> {
        val q = query.trim()
        if (q.isEmpty()) return getCountries()

        val local = (if (cache.isEmpty()) getCountries() else cache)
            .filter { it.name.contains(q, ignoreCase = true) }

        if (local.isNotEmpty()) return local

        return try {
            api.searchByName(q).mapNotNull { it.toDomainOrNull() }
                .sortedBy { it.name.lowercase() }
        } catch (_: Exception) {
            emptyList()
        }
    }

    suspend fun getCountryDetail(code: String): Country? {
        val c = code.trim()
        if (c.isEmpty()) return null

        cache.firstOrNull { it.code.equals(c, ignoreCase = true) }?.let { cached ->
            return try {
                api.getByCode(c).firstOrNull()?.toDomainOrNull() ?: cached
            } catch (_: Exception) {
                cached
            }
        }

        return try {
            api.getByCode(c).firstOrNull()?.toDomainOrNull()
        } catch (_: Exception) {
            null
        }
    }

    private fun CountryDto.toDomainOrNull(): Country? {
        val code = this.cca3 ?: this.cca2 ?: return null
        val nameCommon = this.name?.common ?: return null

        return Country(
            code = code,
            name = nameCommon,
            officialName = this.name?.official ?: nameCommon,
            flagUrl = this.flags?.png ?: this.flags?.svg ?: "",
            capital = this.capital?.firstOrNull() ?: "Sin capital",
            region = this.region ?: "Sin región",
            subregion = this.subregion ?: "Sin subregión",
            population = this.population ?: 0L,
            languages = this.languages?.values?.toList() ?: emptyList()
        )
    }
}