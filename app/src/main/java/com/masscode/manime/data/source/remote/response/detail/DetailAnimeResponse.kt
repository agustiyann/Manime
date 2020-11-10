package com.masscode.manime.data.source.remote.response.detail

import com.squareup.moshi.Json

data class DetailAnimeResponse(
    @Json(name = "mal_id")
    val id: Int? = 0,
    @Json(name = "title")
    val title: String? = "",
    @Json(name = "image_url")
    val imageUrl: String? = "",
    @Json(name = "type")
    val type: String? = "",
    @Json(name = "episodes")
    val episodes: Int? = 0,
    @Json(name = "score")
    val score: Double? = 0.0,
    @Json(name = "status")
    val status: String? = "",
    @Json(name = "duration")
    val duration: String? = "",
    @Json(name = "rating")
    val rating: String? = "",
    @Json(name = "scored_by")
    val scoredBy: Int? = 0,
    @Json(name = "popularity")
    val popularity: Int? = 0,
    @Json(name = "members")
    val members: Int? = 0,
    @Json(name = "synopsis")
    val synopsis: String? = "",
    @Json(name = "premiered")
    val premiered: String? = "",
    @Json(name = "broadcast")
    val broadcast: String? = "",
    @Json(name = "aired")
    val aired: Aired,
    @Json(name = "genres")
    val genres: List<Genres>
)