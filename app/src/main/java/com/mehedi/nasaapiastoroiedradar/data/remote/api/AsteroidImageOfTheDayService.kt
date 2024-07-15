package com.mehedi.nasaapiastoroiedradar.data.remote.api


import com.mehedi.nasaapiastoroiedradar.data.models.ResponseImageOfTheDay
import com.mehedi.nasaapiastoroiedradar.utils.Constant.API_KEY
import com.mehedi.nasaapiastoroiedradar.utils.Constant.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface AsteroidImageOfTheDayService {
    @GET("planetary/apod")
    suspend fun getImageOfTheDay(@Query("api_key") apiKey: String = API_KEY): Response<ResponseImageOfTheDay>
}

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

object Network {
    
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    
    val imageOfTheDayService = retrofit.create(AsteroidImageOfTheDayService::class.java)
    
}