package com.masscode.manime.data.source.remote.response

import com.squareup.moshi.Json

data class TopAnimeResponse(
    @Json(name = "top")
    val top: List<AnimeListResponse>
)