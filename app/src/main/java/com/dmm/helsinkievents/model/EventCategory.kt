package com.dmm.helsinkievents.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class EventCategory(
	@PrimaryKey(autoGenerate = true)
	val id : Int,
	val page : Int = 0,
	val categoryName : String,
	@field:Json(name = "data") val data: List<EventInfo>
)
