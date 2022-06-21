package com.dmm.helsinkievents.di

import com.dmm.helsinkievents.network.EventClient
import com.dmm.helsinkievents.network.EventService
import com.dmm.helsinkievents.utils.Constants.HELSINKI_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	@Provides
	@Singleton
	fun provideRetrofit(): Retrofit {
		return Retrofit.Builder()
			.baseUrl(HELSINKI_BASE_URL)
			.addConverterFactory(MoshiConverterFactory.create())
			.build()
	}

	@Provides
	@Singleton
	fun provideEventService(retrofit: Retrofit): EventService {
		return retrofit.create(EventService::class.java)
	}

	@Provides
	@Singleton
	fun provideEventClient(eventService: EventService): EventClient {
		return EventClient(eventService)
	}
}