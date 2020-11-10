package com.masscode.manime.data.source.remote.response.detail

import com.squareup.moshi.Json

data class CharactersResponse(
    @Json(name = "characters")
    val characters: List<CharactersListResponse>
)