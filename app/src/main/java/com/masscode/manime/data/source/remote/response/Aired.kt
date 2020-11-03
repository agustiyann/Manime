package com.masscode.manime.data.source.remote.response

import com.squareup.moshi.Json

data class Aired(
    @Json(name = "from")
    val from: String? = "",
    @Json(name = "to")
    val to: String? = "",
    @Json(name = "string")
    val string: String? = ""
)