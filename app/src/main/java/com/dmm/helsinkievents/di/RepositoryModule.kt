package com.dmm.helsinkievents.di

import com.dmm.helsinkievents.network.EventClient
import com.dmm.helsinkievents.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

	@Provides
  @ViewModelScoped
  fun provideMainRepository(
    eventClient: EventClient,
    coroutineDispatcher: CoroutineDispatcher
	) : MainRepository {
		return MainRepository(eventClient, coroutineDispatcher)
	}
}