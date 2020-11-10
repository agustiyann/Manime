package com.masscode.manime.data.source.remote.response.search

import com.masscode.manime.data.source.remote.response.AnimeListResponse
import com.squareup.moshi.Json

data class SearchAnimeRespon(
    @Json(name = "results")
    val results: List<AnimeListResponse>
)