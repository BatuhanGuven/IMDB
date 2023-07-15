package com.example.imdb


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class newDetails(
    @SerialName("result")
    val result: ResultX,
    @SerialName("success")
    val success: Boolean
)