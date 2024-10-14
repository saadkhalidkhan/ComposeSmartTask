package com.droidgeeks.smarttasks.domain.model

import com.google.gson.annotations.SerializedName

data class TasksResponseModel(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("TargetDate")
    val targetDate: String? = "",
    @SerializedName("DueDate")
    val dueDate: String? = "",
    @SerializedName("Title")
    val title: String? = "",
    @SerializedName("Description")
    val description: String? = "",
    @SerializedName("Priority")
    val priority: Int? = 0,
)