package com.masscode.manime.data.source.remote.response.detail

import com.squareup.moshi.Json

data class VideosResponse(
    @Json(name = "promo")
    val promo: List<Promo>
)