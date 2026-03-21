package woowacourse.kanbanboard.board.ui.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanbanboard.board.component.KanbanBoard
import woowacourse.kanbanboard.board.data.KanbanBoardSampleData

@OptIn(ExperimentalTestApi::class)
class BoardUiTest {
    @Test
    fun `초기 렌더링 시 헤더 제목과 완료율이 표시된다`() = runComposeUiTest {
        setContent {
            KanbanBoard(
                todoTasks = KanbanBoardSampleData.todoTasks,
                inProgressTasks = KanbanBoardSampleData.inProgressTasks,
                doneTasks = KanbanBoardSampleData.doneTasks,
            )
        }

        onNodeWithText("Compose Desk 칸반 보드").assertExists()
        onNodeWithText("완료율: 50% (3/6)").assertExists()
        onNodeWithTag("open_create_task_button").assertExists()
    }

    @Test
    fun `초기 렌더링 시 세 개의 진행 상태 컬럼이 표시된다`() = runComposeUiTest {
        setContent {
            KanbanBoard(
                todoTasks = KanbanBoardSampleData.todoTasks,
                inProgressTasks = KanbanBoardSampleData.inProgressTasks,
                doneTasks = KanbanBoardSampleData.doneTasks,
            )
        }

        onNodeWithText("To Do").assertExists()
        onNodeWithText("In Progress").assertExists()
        onNodeWithText("Done").assertExists()
    }

    @Test
    fun `할 일 컬럼의 샘플 태스크가 표시된다`() = runComposeUiTest {
        setContent {
            KanbanBoard(
                todoTasks = KanbanBoardSampleData.todoTasks,
                inProgressTasks = KanbanBoardSampleData.inProgressTasks,
                doneTasks = KanbanBoardSampleData.doneTasks,
            )
        }

        onNodeWithText("LazyColumn 컴포넌트 구현").assertExists()
        onNodeWithText("Side-effect API 학습").assertExists()
    }

    @Test
    fun `완료 컬럼의 샘플 태스크가 표시된다`() = runComposeUiTest {
        setContent {
            KanbanBoard(
                todoTasks = KanbanBoardSampleData.todoTasks,
                inProgressTasks = KanbanBoardSampleData.inProgressTasks,
                doneTasks = KanbanBoardSampleData.doneTasks,
            )
        }

        onNodeWithText("리컴포지션 최적화").assertExists()
        onNodeWithText("Mock API 설정").assertExists()
        onNodeWithText("Drag & Drop 기능 구현").assertExists()
    }
}
