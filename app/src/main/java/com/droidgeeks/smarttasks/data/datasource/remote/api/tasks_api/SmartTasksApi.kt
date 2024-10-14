package com.droidgeeks.smarttasks.data.datasource.remote.api.tasks_api

import com.droidgeeks.smarttasks.domain.model.TasksResponseModel
import retrofit2.http.GET

interface SmartTasksApi {
    @GET
    suspend fun tasksData(): List<TasksResponseModel>

}