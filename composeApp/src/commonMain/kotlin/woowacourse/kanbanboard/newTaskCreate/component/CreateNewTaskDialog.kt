package woowacourse.kanbanboard.newTaskCreate.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanbanboard.newTaskCreate.data.Task
import woowacourse.kanbanboard.newTaskCreate.uiState.rememberCreateTaskFormState

@Composable
fun CreateNewTaskDialog(
    onDismiss: () -> Unit,
    onCreateTask: (Task) -> Unit,
) {
    val formState = rememberCreateTaskFormState()

    var onCreate by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .size(672.dp, 818.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
    ) {
        // 상단부
        TopBar(onDismiss)
        HorizontalDivider()
        // 중단부
        NewTaskForm(
            title = formState.titleText,
            onTitleChange = { formState.titleText = it },
            description = formState.description,
            onDescriptionChange = { formState.description = it },
            tags = formState.tags,
            onTagsChange = { formState.tags = it },
            selectedStatusIndex = formState.selectedStatusIndex,
            onStatusChange = { formState.selectedStatusIndex = it },
            selectedProfileIndex = formState.selectedProfileIndex,
            onProfileChange = { formState.selectedProfileIndex = it },
        )
        HorizontalDivider(Modifier.padding(24.dp))
        // 하단부
        CreateNewTaskDialogBottom(
            isCreateEnabled = formState.isCreateEnabled, // 생성 버튼 활성화
            onCreate = {
                val task = Task(
                    taskTitle = formState.titleText,
                    taskScript = formState.description,
                    tags = formState.tags
                        .split(",")
                        .map { it.trim() }
                        .filter { it.isNotEmpty() },
                    nickname = when (formState.selectedStatusIndex){
                        0 -> "다이노"
                        1 -> "페임스"
                        else -> "다이노"
                    },
                )
                onCreateTask(task)
                onDismiss()
            }, // 클릭하면 taskCard가 만들어지도록
        )
    }
}

@Preview(widthDp = 672, heightDp = 818)
@Composable
fun CreateNewTaskDialogPreview(
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
    ) {
        CreateNewTaskDialog(onDismiss = {})
    }
}
