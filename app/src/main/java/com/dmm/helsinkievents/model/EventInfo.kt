package com.dmm.helsinkievents.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class EventInfo(
	@PrimaryKey
	val id: String,
	val audience: List<Audience>,
	val description: Description,
	val images: List<Image>,
	val keywords: List<Keyword>,
	val location: Location,
	val name: Name,
	val offers: List<Offer>,
	val publisher: String,
	@field:Json(name = "audience_max_age") val maxAge: Int,
	@field:Json(name = "audience_min_age") val minAge: Int,
	@field:Json(name = "created_time") val createdTime: String,
	@field:Json(name = "short_description") val shortDescription: ShortDescription,
	@field:Json(name = "start_time") val startTime: String,
	@field:Json(name = "end_time") val endTime: String,
	@field:Json(name = "enrolment_end_time") val enrolmentEndTime: String,
	@field:Json(name = "enrolment_start_time") val enrolmentStartTime: String,
	@field:Json(name = "external_links") val externalLinks: List<ExternalLinks>,
	@field:Json(name = "info_url") val infoUrl: InfoUrl,
	@field:Json(name = "last_modified_time") val lastModifiedTime: String,
	@field:Json(name = "super_event") val superEvent: String,
)
