package com.uam.scheduleapk.reboot

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiAdapter {
    private const val BASE_URL = "https://192.168.220.215.8080/apiAgenda/"
    private val okHttpClient = OkHttpClient.Builder().build()

    // comvierte objetos a json y viceversa

    fun getInstance(): Retrofit { //toda funcionn dentro de un objeto es estatica
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}