package woowacourse.kanban.board.ui.newTaskCreate

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test
import woowacourse.kanban.newTaskCreate.component.CreateNewTaskDialog

@OptIn(ExperimentalTestApi::class)
class CreateNewTaskDialogUiTest {
    @Test
    fun `제목이 비어있으면 생성 버튼이 비활성화 된다`() = runComposeUiTest {
        setContent {
            CreateNewTaskDialog(
                onDismiss = {},
                onCreateTask = {},
            )
        }

        onNodeWithText("생성").assertIsNotEnabled()
    }

    @Test
    fun `제목이 있다면 생성 버튼이 활성화 된다`() = runComposeUiTest {
        setContent {
            CreateNewTaskDialog(
                onDismiss = {},
                onCreateTask = {},
            )
        }

        onNodeWithTag("title_textField").performTextInput("Hello")
        onNodeWithText("생성").assertIsEnabled()
    }

    @Test
    fun `제목에 값이 없다가 입력되면 생성 버튼이 비활성화 상태였다가 활성화 된다`() = runComposeUiTest {
        setContent {
            CreateNewTaskDialog(
                onDismiss = {},
                onCreateTask = {},
            )
        }

        onNodeWithText("생성").assertIsNotEnabled()
        onNodeWithText("To Do").assertExists()
        onNodeWithTag("title_textField").performTextInput("할 일")
        onNodeWithText("생성").assertIsEnabled()
    }
}
