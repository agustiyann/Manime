package com.masscode.manime.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.masscode.manime.data.source.remote.RemoteDataSource
import com.masscode.manime.data.source.remote.response.AnimeListResponse

class Repository private constructor(private val remoteDataSource: RemoteDataSource) : DataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData)
            }
    }

    override suspend fun getAnimeAiring(): LiveData<List<AnimeListResponse>> {
        val animeResult = MutableLiveData<List<AnimeListResponse>>()
        remoteDataSource.getAnimeAiring(object : RemoteDataSource.GetAnimeAiringCallback {
            override fun onAnimeReceived(animeList: List<AnimeListResponse>) {
                animeResult.postValue(animeList)
            }
        })
        return animeResult
    }
}