package com.masscode.manime.data

import androidx.lifecycle.LiveData
import com.masscode.manime.data.source.remote.response.AnimeListResponse

interface DataSource {

    suspend fun getAnimeAiring(): LiveData<List<AnimeListResponse>>
}