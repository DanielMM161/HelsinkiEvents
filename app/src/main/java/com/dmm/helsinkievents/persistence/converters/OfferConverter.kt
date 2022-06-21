package com.dmm.helsinkievents.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.helsinkievents.model.Audience
import com.dmm.helsinkievents.model.InfoUrl
import com.dmm.helsinkievents.model.Offer
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class OfferConverter @Inject constructor(
	private val moshi: Moshi
) {

	@TypeConverter
	fun fromString(value: String): List<Offer>? {
		val listType = Types.newParameterizedType(List::class.java, Offer::class.java)
		val adapter: JsonAdapter<List<Offer>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromOffer(offers: List<Offer>) : String {
		val listType = Types.newParameterizedType(List::class.java, Offer::class.java)
		val adapter: JsonAdapter<List<Offer>> = moshi.adapter(listType)
		return adapter.toJson(offers)
	}

}