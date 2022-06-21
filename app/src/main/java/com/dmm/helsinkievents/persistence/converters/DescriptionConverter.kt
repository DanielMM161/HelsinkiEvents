package com.dmm.helsinkievents.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.helsinkievents.model.Description
import com.dmm.helsinkievents.model.InfoUrl
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class DescriptionConverter @Inject constructor(
	private val moshi: Moshi
) {

	@TypeConverter
	fun fromString(value: String): Description? {
		val listType = Types.newParameterizedType(Description::class.java)
		val adapter: JsonAdapter<Description> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromDescription(description: Description) : String {
		val listType = Types.newParameterizedType(Description::class.java)
		val adapter: JsonAdapter<Description> = moshi.adapter(listType)
		return adapter.toJson(description)
	}

}