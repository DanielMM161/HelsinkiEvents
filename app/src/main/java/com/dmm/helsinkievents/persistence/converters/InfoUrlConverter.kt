package com.dmm.helsinkievents.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.helsinkievents.model.InfoUrl
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class InfoUrlConverter @Inject constructor(
	private val moshi: Moshi
) {

	@TypeConverter
	fun fromString(value: String): InfoUrl? {
		val listType = Types.newParameterizedType(InfoUrl::class.java)
		val adapter: JsonAdapter<InfoUrl> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromInfoUrl(infoUrl: InfoUrl) : String {
		val listType = Types.newParameterizedType(InfoUrl::class.java)
		val adapter: JsonAdapter<InfoUrl> = moshi.adapter(listType)
		return adapter.toJson(infoUrl)
	}

}