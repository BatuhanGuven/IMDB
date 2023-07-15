package com.example.imdb

import android.icu.text.CaseMap.Title
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface MyApiService {
    @GET("imdb/imdbSearchByName")
    fun getData(
        @Header("Authorization") authorization: String,
        @Header("Content-Type") contentType: String,
        @Query("query") query: String

    ): Call<MoviesDataModel> // veya gerçek veri modelinizi buraya ekleyin

    @GET("imdb/imdbSearchById")
    fun gatNewData(
        @Header("Authorization") authorization: String,
        @Header("Content-Type") contentType: String,
        @Query("movieId") movieId: String

    ): Call<newDetails> // veya gerçek veri modelinizi buraya ekleyin

}

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.collectapi.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService = retrofit.create(MyApiService::class.java)
