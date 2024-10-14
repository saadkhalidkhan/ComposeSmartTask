package com.droidgeeks.smarttasks.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.droidgeeks.coreui.ui.reusable.TasksAppBar
import com.droidgeeks.coreui.ui.theme.SmartTasksAppTheme
import com.droidgeeks.smarttask.R
import com.droidgeeks.smarttasks.domain.model.TasksResponseModel

@Composable
fun DetailScreen(
    taskId: String? = "",
    viewModel: DetailViewModel = hiltViewModel()
) {
    DetailScreenContent()

}

@Composable
fun DetailScreenContent(
    task: TasksResponseModel = TasksResponseModel(),
) {
    SmartTasksAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            TasksAppBar(title = stringResource(R.string.task_detail))
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth()) {

                Image(
                    modifier = Modifier.fillMaxWidth()
                        .align(Alignment.TopCenter),
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = R.drawable.task_details),
                    contentDescription = "intro",
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Spacer(modifier = Modifier.height(28.dp))
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
                    Divider(
                        modifier = Modifier.height(1.dp),
                        color = Color(0xFFFFDE61),
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        style = MaterialTheme.typography.h2,
                        text = task.description.orEmpty(),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        color = Color(0xFFEF4B5E)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .height(42.dp),
                    enabled = true,
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF009688),
                        contentColor = Color.White,
                        disabledContainerColor = Color(0xFFACACAC)
                    )
                ) {
                    Text(text = stringResource(R.string.resolve), color = Color(0xFFFFFFFF))
                }
                Spacer(Modifier.width(8.dp))
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .height(42.dp),
                    enabled = true,
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF44336),
                        contentColor = Color.White,
                        disabledContainerColor = Color(0xFFACACAC)
                    )
                ) {
                    Text(text = stringResource(R.string.can_t_resolve), color = Color(0xFFFFFFFF))
                }
            }


        }
    }

}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    SmartTasksAppTheme {
        DetailScreenContent(
            task = TasksResponseModel(
                title = "Task Title",
                dueDate = "Apr 23 2016",
                targetDate = "12",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            )
        )
    }
}