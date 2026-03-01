package com.example.countriesapp.domain.model

data class Country(
    val code: String,               // cca3
    val name: String,
    val officialName: String,
    val flagUrl: String,
    val capital: String,
    val region: String,
    val subregion: String,
    val population: Long,
    val languages: List<String>
)