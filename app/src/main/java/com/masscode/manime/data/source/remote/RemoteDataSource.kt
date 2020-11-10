package com.masscode.manime.data.source.remote

import com.masscode.manime.data.source.remote.network.ApiConfig
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import com.masscode.manime.data.source.remote.response.detail.CharactersListResponse
import com.masscode.manime.data.source.remote.response.detail.DetailAnimeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDataSource private constructor(private val apiConfig: ApiConfig) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null
        fun getInstance(api: ApiConfig): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(api)
        }
    }

    suspend fun getTopAnime(type: String, callback: GetAnimeCallback) {
        withContext(Dispatchers.IO) {
            val animes = apiConfig.api.getTopAnime(type).top
            callback.onAnimeReceived(animes)
        }
    }

    suspend fun getDetailAnime(id: Int, callback: GetDetailCallback) {
        withContext(Dispatchers.IO) {
            val anime = apiConfig.api.getDetailAnime(id)
            callback.onAnimeReceived(anime)
        }
    }

    suspend fun getSeasonAnime(year: Int, season: String, callback: GetAnimeCallback) {
        withContext(Dispatchers.IO) {
            val anime = apiConfig.api.getSeasonAnime(year, season).anime
            callback.onAnimeReceived(anime)
        }
    }

    suspend fun getSearchAnime(query: String, callback: GetAnimeCallback) {
        withContext(Dispatchers.IO) {
            val anime = apiConfig.api.getSearchAnime(query).results
            callback.onAnimeReceived(anime)
        }
    }

    suspend fun getCharacters(id: Int, callback: GetCharactersCallback) {
        withContext(Dispatchers.IO) {
            val characters = apiConfig.api.getCharacters(id).characters
            callback.onCharactersReceived(characters)
        }
    }

    interface GetAnimeCallback {
        fun onAnimeReceived(animeList: List<AnimeListResponse>)
    }

    interface GetDetailCallback {
        fun onAnimeReceived(anime: DetailAnimeResponse)
    }

    interface GetCharactersCallback {
        fun onCharactersReceived(characters: List<CharactersListResponse>)
    }
}