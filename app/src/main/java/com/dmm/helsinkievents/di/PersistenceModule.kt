package com.dmm.helsinkievents.di

import android.app.Application
import androidx.room.Room
import com.dmm.helsinkievents.persistence.AppDatabase
import com.dmm.helsinkievents.persistence.converters.EventInfoConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

	@Provides
	@Singleton
	fun provideAppDatabase(
		application: Application,
		eventInfoConverter: EventInfoConverter
	): AppDatabase {
		return Room
			.databaseBuilder(application, AppDatabase::class.java, "helsinkiEvents.db")
			.fallbackToDestructiveMigration()
			.build()
	}
}