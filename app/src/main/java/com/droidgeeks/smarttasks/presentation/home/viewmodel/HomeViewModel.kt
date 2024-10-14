package com.droidgeeks.smarttasks.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidgeeks.smarttasks.data.datasource.remote.api.SmartTasksRemoteDataSource
import com.droidgeeks.smarttasks.domain.model.TasksResponseModel
import com.droidgeeks.smarttasks.presentation.home.entity.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val smartTasksRemoteDataSource: SmartTasksRemoteDataSource,
) : ViewModel() {

    private val _homeScreenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Initial)
    val homeState = _homeScreenState.asStateFlow()

    private val _tasks = MutableStateFlow<List<TasksResponseModel>?>(null)
    val tasks = _tasks.asStateFlow()

    fun getSmartTasks() {
        viewModelScope.launch {
            _homeScreenState.value = HomeScreenState.Loading
            _tasks.value = smartTasksRemoteDataSource.getTasksData()
        }

    }

    fun fakeTasksList(): List<TasksResponseModel> {
        return MutableList(6) {
            fakeTask()
        }.apply {
            for (i in 2..5) {
                add(
                    i, fakeTask().copy(
                        id = "$i",
                        title = "Task $i"
                    )
                )
            }
        }
    }

    private fun fakeTask(): TasksResponseModel {
        return TasksResponseModel(
            id = "0",
            title = "Task 1",
            targetDate = "5",
            dueDate = "Apr 24 2026"
        )
    }
}