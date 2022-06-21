package com.dmm.helsinkievents.network

import com.dmm.helsinkievents.model.EventCategory
import com.dmm.helsinkievents.model.EventInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EventService {

	@GET("event")
	suspend fun fetchEventList(
		@Query("page") page: Int = 1,
		@Query("start") start: String = "today",
		@Query("keyword") category: String,
		@Query("page_size") pageSize: Int = 10
	): Response<EventCategory>

	@GET("event/{id}")
	suspend fun fetchEventInfo(@Path("name") name: String): Response<EventInfo>
}