package com.masscode.manime.data.source.remote.network

import com.masscode.manime.data.source.remote.response.DetailAnimeResponse
import com.masscode.manime.data.source.remote.response.TopAnimeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("top/anime/1/{type}")
    suspend fun getTopAnime(@Path("type") type: String): TopAnimeResponse

    @GET("anime/{mal_id}")
    suspend fun getDetailAnime(@Path("mal_id") mal_id: Int): DetailAnimeResponse
}