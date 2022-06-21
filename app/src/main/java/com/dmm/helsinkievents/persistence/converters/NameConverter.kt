package com.dmm.helsinkievents.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.helsinkievents.model.Location
import com.dmm.helsinkievents.model.Name
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class NameConverter @Inject constructor(
	private val moshi: Moshi
) {

	@TypeConverter
	fun fromString(value: String): Name? {
		val listType = Types.newParameterizedType(Name::class.java)
		val adapter: JsonAdapter<Name> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromName(name: Name): String {
		val listType = Types.newParameterizedType(Name::class.java)
		val adapter: JsonAdapter<Name> = moshi.adapter(listType)
		return adapter.toJson(name)
	}

}