package com.masscode.manime.data.source.remote

import com.masscode.manime.data.source.remote.network.ApiConfig
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import com.masscode.manime.data.source.remote.response.DetailAnimeResponse
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

    interface GetAnimeCallback {
        fun onAnimeReceived(animeList: List<AnimeListResponse>)
    }

    interface GetDetailCallback {
        fun onAnimeReceived(anime: DetailAnimeResponse)
    }
}