package woowacourse.kanbanboard.board.ui.newTaskCreate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import junit.framework.TestCase.assertEquals
import org.junit.Test
import woowacourse.kanbanboard.newTaskCreate.component.NewTaskForm

class NewTaskFormUiTest {
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `상태는 To Do, In Progress, Done 중 하나만 선텍힐 수 있다`() = runComposeUiTest {
        var selectedStatusIndex by mutableStateOf(0)
        setContent {
            NewTaskForm(
                title = "",
                onTitleChange = {},
                description = "",
                onDescriptionChange = {},
                tags = "",
                onTagsChange = {},
                selectedStatusIndex = selectedStatusIndex,
                onStatusChange = { selectedStatusIndex = it },
                selectedProfileIndex = 0,
                onProfileChange = {},
            )
        }

        onNodeWithText("In Progress").performClick()
        assertEquals(selectedStatusIndex, 1)

        onNodeWithText("Done").performClick()
        assertEquals(selectedStatusIndex, 2)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `담당자는 1명만 선택할 수 있다`() = runComposeUiTest {
        var selectedProfileIndex by mutableStateOf(0)

        setContent {
            NewTaskForm(
                title = "",
                onTitleChange = {},
                description = "",
                onDescriptionChange = {},
                tags = "",
                onTagsChange = {},
                selectedStatusIndex = 0,
                onStatusChange = {},
                selectedProfileIndex = selectedProfileIndex,
                onProfileChange = { selectedProfileIndex = it },
            )
        }

        onNodeWithText("다이노").performClick()
        assertEquals(selectedProfileIndex, 0)

        onNodeWithText("페임스").performClick()
        assertEquals(selectedProfileIndex, 1)
    }
}
