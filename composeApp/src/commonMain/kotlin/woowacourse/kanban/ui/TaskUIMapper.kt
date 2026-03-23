package woowacourse.kanban.ui

import androidx.compose.runtime.Composable
import woowacourse.kanban.newTaskCreate.component.TaskCard
import woowacourse.kanban.newTaskCreate.data.Task

class TaskUIMapper {
    @Composable
    fun createTaskUI(tasks: List<Task>) {
        tasks.forEach { task ->
            TaskCard(task.taskTitle, task.taskScript, task.tags, task.nickname)
        }
    }
}