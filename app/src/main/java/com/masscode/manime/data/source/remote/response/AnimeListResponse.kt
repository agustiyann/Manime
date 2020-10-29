package com.masscode.manime.data.source.remote.response

import com.squareup.moshi.Json

data class AnimeListResponse(
    @Json(name = "mal_id")
    val id: Int? = 0,
    @Json(name = "title")
    val title: String? = "",
    @Json(name = "image_url")
    val imageUrl: String? = "",
    @Json(name = "score")
    val score: Double? = 0.0
)