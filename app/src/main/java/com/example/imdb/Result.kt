package com.example.imdb


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("imdbID")
    val imdbID: String,
    @SerialName("Poster")
    val Poster: String,
    @SerialName("Title")
    val Title: String,
    @SerialName("Type")
    val Type: String,
    @SerialName("Year")
    val Year: String
)