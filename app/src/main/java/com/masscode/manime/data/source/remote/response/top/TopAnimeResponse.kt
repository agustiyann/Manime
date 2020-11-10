package com.masscode.manime.data.source.remote.response.top

import com.masscode.manime.data.source.remote.response.AnimeListResponse
import com.squareup.moshi.Json

data class TopAnimeResponse(
    @Json(name = "top")
    val top: List<AnimeListResponse>
)