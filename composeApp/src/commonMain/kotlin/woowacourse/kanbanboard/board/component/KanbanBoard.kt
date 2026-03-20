package woowacourse.kanbanboard.board.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanbanboard.board.CustomColor
import woowacourse.kanbanboard.board.data.KanbanBoardSampleData
import woowacourse.kanbanboard.newTaskCreate.component.CreateNewTaskDialogOverlay
import woowacourse.kanbanboard.newTaskCreate.data.Task

@Composable
fun KanbanBoard(
    todoTasks: List<Task>,
    inProgressTasks: List<Task>,
    doneTasks: List<Task>,
) {
    // 새 태스크 생성 버튼을 눌렀을 때 상태를 변경하기 위함
    var isDialogOpen by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .size(1295.dp, 909.dp)
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState()),
    ) {
        // 헤더
        Header(
            totalCount = todoTasks.size + inProgressTasks.size + doneTasks.size,
            doneCount = doneTasks.size,
            onClick = { isDialogOpen = true },
        )
        Row(
            modifier = Modifier.padding(top = 24.dp, start = 24.dp, bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            // 칸반 카드들
            ProgressCard(
                title = "To Do",
                headerColor = CustomColor.Blue600,
                bodyColor = CustomColor.Blue50,
                borderColor = CustomColor.Blue200,
                tasks = todoTasks,
            )
            ProgressCard(
                title = "In Progress",
                headerColor = CustomColor.Orange700,
                bodyColor = CustomColor.Yellow100,
                borderColor = CustomColor.Yellow300,
                tasks = inProgressTasks,
            )
            ProgressCard(
                title = "Done",
                headerColor = CustomColor.Green700,
                bodyColor = CustomColor.Green50,
                borderColor = CustomColor.Green200,
                tasks = doneTasks,
            )
        }
    }
    if (isDialogOpen) {
        CreateNewTaskDialogOverlay(onDismiss = { isDialogOpen = false })
    }
}

@Preview(showBackground = true, widthDp = 1295, heightDp = 909)
@Composable
private fun KanbanBoardPreview() {

    KanbanBoard(
        todoTasks = KanbanBoardSampleData.todoTasks,
        inProgressTasks = KanbanBoardSampleData.inProgressTasks,
        doneTasks = KanbanBoardSampleData.doneTasks,
    )
}
