package com.example.rickmorty.utils.dto

import com.google.gson.annotations.SerializedName

data class RickMortyModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)