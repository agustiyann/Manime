package com.masscode.manime.data

import com.masscode.manime.data.source.remote.response.AnimeListResponse

interface DataSource {

    suspend fun getAnimeAiring(): List<AnimeListResponse>

    suspend fun getAnimeUpcoming(): List<AnimeListResponse>

    suspend fun getAnimeTV(): List<AnimeListResponse>
}