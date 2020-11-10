package com.masscode.manime.data

import com.masscode.manime.data.source.remote.response.AnimeListResponse
import com.masscode.manime.data.source.remote.response.CharactersListResponse
import com.masscode.manime.data.source.remote.response.DetailAnimeResponse

interface DataSource {

    suspend fun getTopAnime(type: String): List<AnimeListResponse>

    suspend fun getDetailAnime(id: Int): DetailAnimeResponse

    suspend fun getSeasonAnime(year: Int, season: String): List<AnimeListResponse>

    suspend fun getSearchAnime(query: String): List<AnimeListResponse>

    suspend fun getCharacters(id: Int): List<CharactersListResponse>
}