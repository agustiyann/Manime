package com.masscode.manime.data.source.remote.response

import com.squareup.moshi.Json

data class SeasonAnimeRespon(
    @Json(name = "season_name")
    val season: String,
    @Json(name = "season_year")
    val year: Int,
    @Json(name = "anime")
    val anime: List<AnimeListResponse>
)