package com.example.imdb


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    @SerialName("Source")
    val Source: String,
    @SerialName("Value")
    val Value: String
)