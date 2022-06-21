package com.dmm.helsinkievents.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.dmm.helsinkievents.repository.MainRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
	private val mainRepository: MainRepository
) : ViewModel() {
}