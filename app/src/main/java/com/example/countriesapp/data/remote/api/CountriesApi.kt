package com.example.countriesapp.data.remote.api

import com.example.countriesapp.data.remote.dto.CountryDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountriesApi {

    @GET("all")
    suspend fun getAllCountries(
        @Query("fields") fields: String = "name,flags,capital,region,population,cca2,cca3"
    ): List<CountryDto>

    @GET("name/{name}")
    suspend fun searchByName(
        @Path("name") name: String,
        @Query("fields") fields: String = "name,flags,capital,region,population,cca2,cca3"
    ): List<CountryDto>

    @GET("alpha/{code}")
    suspend fun getByCode(
        @Path("code") code: String,
        @Query("fields") fields: String = "name,flags,capital,region,subregion,population,languages,cca2,cca3"
    ): List<CountryDto>
}