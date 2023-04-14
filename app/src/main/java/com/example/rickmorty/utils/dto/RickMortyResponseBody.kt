package com.example.rickmorty.utils.dto

import com.google.gson.annotations.SerializedName

    data class RickMortyResponseBody (
        @SerializedName("count")
        val count: Int,
        @SerializedName("next")
        val next: String,
        @SerializedName("results")
        val results: List<RickMortyModel>
    )