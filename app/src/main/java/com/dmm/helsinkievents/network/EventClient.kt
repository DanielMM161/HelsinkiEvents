package com.dmm.helsinkievents.network

import androidx.annotation.VisibleForTesting
import com.dmm.helsinkievents.model.EventCategory
import retrofit2.Response
import javax.inject.Inject

class EventClient @Inject constructor(
	private val eventService: EventService
) {
	suspend fun fetchEventList(
		page: Int
	): Response<EventCategory> =
		eventService.fetchEventList(
			page = page,
			category = ""
		)
}