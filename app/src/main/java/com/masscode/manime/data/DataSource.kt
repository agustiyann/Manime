package com.masscode.manime.data

import com.masscode.manime.data.source.remote.response.AnimeListResponse
import com.masscode.manime.data.source.remote.response.DetailAnimeResponse

interface DataSource {

    suspend fun getTopAnime(type: String): List<AnimeListResponse>

    suspend fun getDetailAnime(id: Int): DetailAnimeResponse
}