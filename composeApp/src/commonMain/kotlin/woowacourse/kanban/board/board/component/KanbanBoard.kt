package woowacourse.kanban.board.board.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.CustomColor
import woowacourse.kanban.board.data.Task

@Composable
fun KanbanBoard(
    todoTasks: List<Task>,
    inProgressTasks: List<Task>,
    doneTasks: List<Task>,
) {
    Column(
        modifier = Modifier
            .size(1295.dp, 909.dp),
    ) {
        // 헤더
        Header(
            totalCount = todoTasks.size + inProgressTasks.size + doneTasks.size,
            doneCount = doneTasks.size,
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
}

@Preview(showBackground = true, widthDp = 1295, heightDp = 909)
@Composable
private fun KanbanBoardPreview() {

    KanbanBoard(
        todoTasks = listOf<Task>(
            Task(
                taskTitle = "LazyColumn 컴포넌트 구현",
                taskScript = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tags = listOf("컴포넌트", "성능"),
                nickname = "다이노",
            ),
            Task(
                taskTitle = "Side-effect API 학습",
                taskScript = "LaunchedEffect, DisposableEffect 등의 API를 학습하고 적절한 사용 예제를 작성합니다.",
                tags = listOf("학습", "API"),
                nickname = "페임스",
            ),
        ),
        inProgressTasks = listOf<Task>(
            Task(
                taskTitle = "상태 관리 리팩토링",
                taskScript = "복잡한 상태를 효율적으로 관리하기 위한 구조를 설계합니다.",
                tags = listOf("리팩토링", "상태관리"),
                nickname = "다이노",
            ),
        ),
        doneTasks = listOf<Task>(
            Task(
                taskTitle = "리컴포지션 최적화",
                taskScript = "derivedStateOf와 key를 활용하여 불필요한 리컴포지션을 방지합니다.",
                tags = listOf("최적화", "성능"),
                nickname = "페임스",
            ),
            Task(
                taskTitle = "Mock API 설정",
                taskScript = "JSON 파일 또는 Mock API를 통해 초기 데이터를 로드하는 로직을 구현합니다.",
                tags = listOf("API", "비동기"),
                nickname = "페임스",
            ),
            Task(
                taskTitle = "Drag & Drop 기능 구현",
                taskScript = "카드를 드래그하여 다른 컬럼으로 이동할 수 있는 기능을 구현합니다.",
                tags = listOf("기능", "UX"),
                nickname = "다이노",
            ),
        ),
    )
}