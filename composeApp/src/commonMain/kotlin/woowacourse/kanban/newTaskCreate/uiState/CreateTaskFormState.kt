package woowacourse.kanban.newTaskCreate.uiState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import woowacourse.kanban.newTaskCreate.component.validateTags
import woowacourse.kanban.newTaskCreate.component.validateTitle

@Stable
class CreateTaskFormState {
    var titleText by mutableStateOf("")
    var description by mutableStateOf("")
    var tags by mutableStateOf("")
    var selectedStatusIndex by mutableStateOf(0)
    var selectedProfileIndex by mutableStateOf(0)

    val isCreateEnabled: Boolean
        get() = validateTitle(
            titleText
        ) == null && validateTags(
            tags
        ) == null
}

@Composable
fun rememberCreateTaskFormState(): CreateTaskFormState = remember { CreateTaskFormState() }
