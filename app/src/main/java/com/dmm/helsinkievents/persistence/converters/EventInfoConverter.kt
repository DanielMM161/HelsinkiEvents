package com.dmm.helsinkievents.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.helsinkievents.model.EventInfo
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class EventInfoConverter @Inject constructor(
	private val moshi: Moshi
) {

	@TypeConverter
	fun fromString(value: String): List<EventInfo>? {
		val listType = Types.newParameterizedType(List::class.java, EventInfo::class.java)
		val adapter: JsonAdapter<List<EventInfo>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromEventInfo(eventInfo: List<EventInfo>) : String {
		val listType = Types.newParameterizedType(List::class.java, EventInfo::class.java)
		val adapter: JsonAdapter<List<EventInfo>> = moshi.adapter(listType)
		return adapter.toJson(eventInfo)
	}

}