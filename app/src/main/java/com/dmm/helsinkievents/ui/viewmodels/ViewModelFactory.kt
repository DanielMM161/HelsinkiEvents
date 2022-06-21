package com.dmm.helsinkievents.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dmm.helsinkievents.repository.MainRepository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
	private val mainRepository: MainRepository
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		return MainViewModel(mainRepository) as T
	}
}