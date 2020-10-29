package com.masscode.manime.data.source.remote.network

import com.masscode.manime.data.source.remote.response.TopAnimeResponse
import retrofit2.http.GET

interface ApiServices {

    @GET("top/anime/1/airing")
    suspend fun getAnimeAiring(): TopAnimeResponse

    @GET("top/anime/1/upcoming")
    suspend fun getAnimeUpcoming(): TopAnimeResponse

    @GET("top/anime/1/tv")
    suspend fun getAnimeTV(): TopAnimeResponse
}