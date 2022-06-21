package com.dmm.helsinkievents.repository

import androidx.annotation.WorkerThread
import com.dmm.helsinkievents.network.EventClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

import javax.inject.Inject

class MainRepository @Inject constructor(
	private val eventClient: EventClient,
	private val ioDispatcher: CoroutineDispatcher
) {

	@WorkerThread
	fun fetchEventList(
		onStart: () -> Unit,
		onComplete: () -> Unit,
		onError: (String) -> Unit
	) = flow {
		emit("")
	}.onStart { onStart()}.onCompletion { onComplete() }.flowOn(ioDispatcher)
}