package com.dmm.helsinkievents.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.helsinkievents.model.Image
import com.dmm.helsinkievents.model.Keyword
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class KeywordConverter @Inject constructor(
	private val moshi: Moshi
) {

	@TypeConverter
	fun fromString(value: String): List<Keyword>? {
		val listType = Types.newParameterizedType(List::class.java, Keyword::class.java)
		val adapter: JsonAdapter<List<Keyword>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromKeyword(keywords: List<Keyword>) : String {
		val listType = Types.newParameterizedType(List::class.java, Keyword::class.java)
		val adapter: JsonAdapter<List<Keyword>> = moshi.adapter(listType)
		return adapter.toJson(keywords)
	}

}