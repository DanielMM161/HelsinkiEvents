package com.dmm.helsinkievents.model

import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class EventResponse(
	@field:Json(name = "data") val data : List<EventInfo>
)
