package com.dmm.helsinkievents.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.helsinkievents.model.ExternalLinks
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ExternalLinksConverter @Inject constructor(
	private val moshi: Moshi
) {

	@TypeConverter
	fun fromString(value: String): List<ExternalLinks>? {
		val listType = Types.newParameterizedType(List::class.java, ExternalLinks::class.java)
		val adapter: JsonAdapter<List<ExternalLinks>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromExternalLinks(externalLinks: List<ExternalLinks>) : String {
		val listType = Types.newParameterizedType(List::class.java, ExternalLinks::class.java)
		val adapter: JsonAdapter<List<ExternalLinks>> = moshi.adapter(listType)
		return adapter.toJson(externalLinks)
	}

}