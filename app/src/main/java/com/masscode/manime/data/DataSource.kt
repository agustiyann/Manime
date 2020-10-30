package com.masscode.manime.data

import com.masscode.manime.data.source.remote.response.AnimeListResponse

interface DataSource {

    suspend fun getTopAnime(type: String): List<AnimeListResponse>
}