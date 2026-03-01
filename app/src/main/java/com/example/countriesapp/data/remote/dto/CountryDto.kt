package com.example.countriesapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("name") val name: NameDto? = null,
    @SerializedName("flags") val flags: FlagsDto? = null,
    @SerializedName("capital") val capital: List<String>? = null,
    @SerializedName("region") val region: String? = null,
    @SerializedName("subregion") val subregion: String? = null,
    @SerializedName("population") val population: Long? = null,
    @SerializedName("languages") val languages: Map<String, String>? = null,
    @SerializedName("cca2") val cca2: String? = null,
    @SerializedName("cca3") val cca3: String? = null
)