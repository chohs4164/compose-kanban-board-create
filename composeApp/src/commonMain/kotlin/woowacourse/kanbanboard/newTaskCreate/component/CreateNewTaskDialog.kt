package woowacourse.kanbanboard.newTaskCreate.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanbanboard.newTaskCreate.uiState.rememberCreateTaskFormState

@Composable
fun CreateNewTaskDialog() {
    val formState =
        rememberCreateTaskFormState()

    Column {
        // 상단부
        TopBar()
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
        Box(modifier = Modifier.padding(vertical = 16.dp)) {
            CreateNewTaskDialogBottom(
                isCreateEnabled = formState.isCreateEnabled
            )
        }
    }
}

@Preview(widthDp = 672, heightDp = 1000)
@Composable
fun CreateNewTaskDialogPreview(
) {
    CreateNewTaskDialog()
}
