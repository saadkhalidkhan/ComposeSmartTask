package com.droidgeeks.smarttasks.presentation.home.entity

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidgeeks.coreui.ui.theme.SmartTasksAppTheme
import com.droidgeeks.smarttask.R
import com.droidgeeks.smarttasks.domain.model.TasksResponseModel

@Composable
fun TasksItem(
    modifier: Modifier = Modifier,
    task: TasksResponseModel = TasksResponseModel(),
    onClickItem: (TasksResponseModel) -> Unit = {},
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClickItem(task)
            },
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xFFFFFFFF),
        ),
        backgroundColor = Color(0xFFFFFFFF),
        elevation = 0.dp,
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(
                style = MaterialTheme.typography.h1,
                text = task.title.orEmpty(),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFFEF4B5E)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                modifier = Modifier.height(1.dp),
                color = Color(0xFFFFDE61),
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.h3,
                    text = stringResource(R.string.due_date),
                    maxLines = 1,
                    color = Color(0xFF3D3738),
                )
                Text(
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.End,
                    maxLines = 1,
                    text = stringResource(R.string.days_left),
                    color = Color(0xFF3D3738),
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.h1,
                    color = Color(0xFFEF4B5E),
                    text = task.dueDate.orEmpty(),
                    maxLines = 1,
                )
                Text(
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.h1,
                    color = Color(0xFFEF4B5E),
                    textAlign = TextAlign.End,
                    maxLines = 1,
                    text = task.targetDate.orEmpty()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun TasksItemPreview() {
    SmartTasksAppTheme {
        TasksItem(
            task = TasksResponseModel(
                title = "Task Title",
                dueDate = "Apr 23 2016",
                targetDate = "12"
            )
        )
    }
}