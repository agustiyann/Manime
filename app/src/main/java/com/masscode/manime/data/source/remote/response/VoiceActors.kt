package com.masscode.manime.data.source.remote.response

import com.squareup.moshi.Json

data class VoiceActors(
    @Json(name = "mal_id")
    val id: Int? = 0,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "image_url")
    val image: String? = "",
    @Json(name = "language")
    val language: String? = ""
)