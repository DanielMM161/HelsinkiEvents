package com.dmm.helsinkievents.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.helsinkievents.model.Audience
import com.dmm.helsinkievents.model.InfoUrl
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class AudienceConverter @Inject constructor(
	private val moshi: Moshi
) {

	@TypeConverter
	fun fromString(value: String): List<Audience>? {
		val listType = Types.newParameterizedType(List::class.java, InfoUrl::class.java)
		val adapter: JsonAdapter<List<Audience>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromAudience(audience: List<Audience>) : String {
		val listType = Types.newParameterizedType(List::class.java, InfoUrl::class.java)
		val adapter: JsonAdapter<List<Audience>> = moshi.adapter(listType)
		return adapter.toJson(audience)
	}

}