package com.masscode.manime.data.source.remote.response.detail

import com.squareup.moshi.Json

data class CharactersListResponse(
    @Json(name = "mal_id")
    val id: Int? = 0,
    @Json(name = "image_url")
    val imageUrl: String? = "",
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "role")
    val role: String? = "",
    @Json(name = "voice_actors")
    val voiceActors: List<VoiceActors>
)