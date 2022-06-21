package com.dmm.helsinkievents.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dmm.helsinkievents.model.EventCategory
import com.dmm.helsinkievents.model.EventInfo
import com.dmm.helsinkievents.persistence.converters.*

@Database(entities = [EventInfo::class, EventCategory::class], version = 1, exportSchema = false)
@TypeConverters(value = [
	EventInfoConverter::class,
	ShortDescriptionConverter::class,
	ExternalLinksConverter::class,
	InfoUrlConverter::class,
	AudienceConverter::class,
	DescriptionConverter::class,
	ImageConverter::class,
	KeywordConverter::class,
	LocationConverter::class,
	NameConverter::class,
	OfferConverter::class
])
abstract class AppDatabase : RoomDatabase() {
}