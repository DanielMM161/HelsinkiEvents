package com.dmm.helsinkievents.model

import com.squareup.moshi.Json

data class Image(
    @field:Json(name = "@context") val context: String,
    @field:Json(name = "@id") val idUrl: String,
    @field:Json(name = "@type") val type: String,
    val id: Int,
    val alt_text: Any,
    val created_time: String,
    val cropping: String,
    val data_source: String,
    val last_modified_time: String,
    val license: String,
    val name: String,
    val photographer_name: Any,
    val publisher: String,
    val url: String
)