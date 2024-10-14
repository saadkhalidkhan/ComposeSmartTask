package com.droidgeeks.smarttasks.presentation.details

import androidx.lifecycle.ViewModel
import com.droidgeeks.smarttasks.data.datasource.remote.api.SmartTasksRemoteDataSource
import com.droidgeeks.smarttasks.presentation.home.entity.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val smartTasksRemoteDataSource: SmartTasksRemoteDataSource
) : ViewModel() {
    private val _homeScreenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Initial)

}