package woowacourse.kanban.newTaskCreate.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import woowacourse.kanban.newTaskCreate.data.Task

@Composable
fun CreateNewTaskDialogOverlay(
    onDismiss: () -> Unit,
    onCreateTask: (Task) -> Unit,
) {
    Dialog(onDismissRequest = onDismiss) {
        CreateNewTaskDialog(
            onDismiss = onDismiss,
            onCreateTask = onCreateTask,
        )
    }
}

@Preview(showBackground = true, widthDp = 1294, heightDp = 1000)
@Composable
private fun CreateNewTaskDialogOverlayPreivew() {
    CreateNewTaskDialogOverlay(
        onDismiss = {},
        onCreateTask = {},
    )
}
