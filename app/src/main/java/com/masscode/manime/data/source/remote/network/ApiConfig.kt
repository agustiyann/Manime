package com.masscode.manime.data.source.remote.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiConfig {

    val api: ApiServices
    private val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
        api = retrofit.create(ApiServices::class.java)
    }
}