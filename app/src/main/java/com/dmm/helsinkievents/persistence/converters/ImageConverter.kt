package com.dmm.helsinkievents.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.helsinkievents.model.EventInfo
import com.dmm.helsinkievents.model.Image
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ImageConverter @Inject constructor(
	private val moshi: Moshi
) {

	@TypeConverter
	fun fromString(value: String): List<Image>? {
		val listType = Types.newParameterizedType(List::class.java, Image::class.java)
		val adapter: JsonAdapter<List<Image>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromImage(images: List<Image>) : String {
		val listType = Types.newParameterizedType(List::class.java, Image::class.java)
		val adapter: JsonAdapter<List<Image>> = moshi.adapter(listType)
		return adapter.toJson(images)
	}

}