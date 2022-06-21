package com.dmm.helsinkievents.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.helsinkievents.model.ShortDescription
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ShortDescriptionConverter @Inject constructor(
	private val moshi: Moshi
) {

	@TypeConverter
	fun fromString(value: String): ShortDescription? {
		val listType = Types.newParameterizedType(ShortDescription::class.java)
		val adapter: JsonAdapter<ShortDescription> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromShortDescription(shortDescription: ShortDescription): String {
		val listType = Types.newParameterizedType(ShortDescription::class.java)
		val adapter: JsonAdapter<ShortDescription> = moshi.adapter(listType)
		return adapter.toJson(shortDescription)
	}
}