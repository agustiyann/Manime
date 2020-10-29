package com.masscode.manime.data.source.remote

import com.masscode.manime.data.source.remote.network.ApiConfig
import com.masscode.manime.data.source.remote.response.AnimeListResponse
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

    suspend fun getAnimeAiring(callback: GetAnimeAiringCallback) {
        withContext(Dispatchers.IO) {
            val animes = apiConfig.api.getAnimeAiring().top
            callback.onAnimeReceived(animes)
        }
    }

    interface GetAnimeAiringCallback {
        fun onAnimeReceived(animeList: List<AnimeListResponse>)
    }
}