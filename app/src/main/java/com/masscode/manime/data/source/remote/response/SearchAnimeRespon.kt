package com.masscode.manime.data.source.remote.response

import com.squareup.moshi.Json

data class SearchAnimeRespon(
    @Json(name = "results")
    val results: List<AnimeListResponse>
)