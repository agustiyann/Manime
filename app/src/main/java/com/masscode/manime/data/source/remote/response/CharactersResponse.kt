package com.masscode.manime.data.source.remote.response

import com.squareup.moshi.Json

data class CharactersResponse(
    @Json(name = "characters")
    val characters: List<CharactersListResponse>
)