package com.example.imdb


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesDataModel(
    @SerialName("result")
    val result: MutableList<Result>,
    @SerialName("success")
    val success: Boolean
)