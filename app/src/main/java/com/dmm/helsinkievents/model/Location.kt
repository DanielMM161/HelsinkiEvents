package com.dmm.helsinkievents.model

import com.squareup.moshi.Json

data class Location(
    @field:Json(name = "@id") val id: String
)