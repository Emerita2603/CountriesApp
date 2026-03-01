package com.example.countriesapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class NameDto(
    @SerializedName("common") val common: String? = null,
    @SerializedName("official") val official: String? = null
)