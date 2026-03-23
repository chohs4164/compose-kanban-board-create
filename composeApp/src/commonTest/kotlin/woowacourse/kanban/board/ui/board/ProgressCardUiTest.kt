package woowacourse.kanban.board.ui.board

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.component.ProgressCard
import woowacourse.kanban.newTaskCreate.data.Task

@OptIn(ExperimentalTestApi::class)
class ProgressCardUiTest {
    @Test
    fun `제목과 태스크 목록이 주어지면 헤더와 카드가 모두 렌더링된다`() = runComposeUiTest {
        val tasks = listOf(
            Task(taskTitle = "카드 A", taskScript = "설명 A", tags = listOf("태그1"), nickname = "다이노"),
            Task(taskTitle = "카드 B", taskScript = "설명 B", tags = listOf("태그2"), nickname = "페임스"),
        )

        setContent {
            ProgressCard(
                title = "To Do",
                headerColor = Color.Blue,
                borderColor = Color.Cyan,
                bodyColor = Color.White,
                tasks = tasks,
            )
        }

        onNodeWithText("To Do").assertExists()
        onNodeWithText("2").assertExists()
        onNodeWithText("카드 A").assertExists()
        onNodeWithText("카드 B").assertExists()
        onNodeWithText("다이노").assertExists()
        onNodeWithText("페임스").assertExists()
    }

    @Test
    fun `태스크가 비어있으면 카운트는 0이고 카드 본문은 생성되지 않는다`() = runComposeUiTest {
        setContent {
            ProgressCard(
                title = "Done",
                headerColor = Color.Green,
                borderColor = Color.Gray,
                bodyColor = Color.White,
                tasks = emptyList(),
            )
        }

        onNodeWithText("Done").assertExists()
        onNodeWithText("0").assertExists()
        onNodeWithText("카드 A").assertDoesNotExist()
        onAllNodesWithTag("tag_item").assertCountEquals(0)
    }
}
