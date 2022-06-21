package com.dmm.helsinkievents.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.helsinkievents.model.InfoUrl
import com.dmm.helsinkievents.model.Location
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class LocationConverter @Inject constructor(
	private val moshi: Moshi
) {

	@TypeConverter
	fun fromString(value: String): Location? {
		val listType = Types.newParameterizedType(Location::class.java)
		val adapter: JsonAdapter<Location> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromLocation(location: Location): String {
		val listType = Types.newParameterizedType(Location::class.java)
		val adapter: JsonAdapter<Location> = moshi.adapter(listType)
		return adapter.toJson(location)
	}

}