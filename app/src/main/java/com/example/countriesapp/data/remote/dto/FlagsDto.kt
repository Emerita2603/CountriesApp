package com.example.countriesapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FlagsDto(
    @SerializedName("png") val png: String? = null,
    @SerializedName("svg") val svg: String? = null,
    @SerializedName("alt") val alt: String? = null
)