package woowacourse.kanbanboard.ui

import androidx.compose.runtime.Composable
import woowacourse.kanbanboard.newTaskCreate.component.TaskCard
import woowacourse.kanbanboard.newTaskCreate.data.Task

class TaskUIMapper {
    @Composable
    fun createTaskUI(tasks: List<Task>) {
        tasks.forEach { task ->
            TaskCard(task.taskTitle, task.taskScript, task.tags, task.nickname)
        }
    }
}