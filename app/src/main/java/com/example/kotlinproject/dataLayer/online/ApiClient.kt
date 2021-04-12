package com.example.kotlinproject.dataLayer.online

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object ApiClient {
    private const val BASE_URL = "https://api.openweathermap.org/"

    const val API_KEY_VALUE = "fae7190d7e6433ec3a45285ffcf55c86"
    const val RATE_LIMITER_TYPE = "data"
    const val API_KEY_QUERY = "appid"


    var gson = GsonBuilder()
        .setLenient()
        .create()
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create()) //important
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }



    val apiService: ApiInterface = getRetrofit().create(ApiInterface::class.java)

    object AlgoliaKeys {
        const val APPLICATION_ID = "plNW8IW0YOIN"
        const val SEARCH_API_KEY = "029766644cb160efa51f2a32284310eb"
    }

    object Coords {
        const val LAT = "lat"
        const val LON = "lon"
        const val METRIC = "metric"
    }
}
