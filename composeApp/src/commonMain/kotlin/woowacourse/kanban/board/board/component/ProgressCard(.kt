package woowacourse.kanban.board.board.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.CustomColor
import woowacourse.kanban.board.component.task.TaskCard
import woowacourse.kanban.board.data.Task

@Composable
fun ProgressCard(
    title: String,
    headerColor: Color,
    borderColor: Color,
    bodyColor: Color,
    tasks: List<Task>,
) {
    // 전체 박스
    Column(
        modifier = Modifier
            .size(320.dp, 748.dp)
            .clip(
                RoundedCornerShape(10.dp),
            )
            .border(width = 1.dp, color = borderColor),
    ) {
        // 헤더 부분
        Row(
            modifier = Modifier
                .size(320.dp, 48.dp)
                .background(headerColor)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Box(
                modifier = Modifier
                    .size(29.dp, 24.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = tasks.size.toString(),
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
        // 몸통 부분
        Column(
            modifier = Modifier
                .size(320.dp, 700.dp)
                .background(bodyColor)
                .padding(top = 16.dp, start = 17.dp, end = 17.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            tasks.forEach { task ->
                TaskCard(
                    title = task.taskTitle,
                    script = task.taskScript,
                    tags = task.tags,
                    nickname = task.nickname,
                )
            }
        }
    }
}

data class ProgressCardPreviewModel(
    val title: String,
    val headerColor: Color,
    val bodyColor: Color,
    val borderColor: Color,
    val tasks: List<Task>,
)

class ProgressCardPreviewProvider : PreviewParameterProvider<ProgressCardPreviewModel> {
    override val values = sequenceOf(
        ProgressCardPreviewModel(
            title = "To Do",
            headerColor = CustomColor.Blue600,
            bodyColor = CustomColor.Blue50,
            borderColor = CustomColor.Blue200,
            tasks = listOf<Task>(
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
        ),
        ProgressCardPreviewModel(
            title = "In Progress",
            headerColor = CustomColor.Orange700,
            bodyColor = CustomColor.Yellow100,
            borderColor = CustomColor.Yellow300,
            tasks = listOf<Task>(
                Task(
                    taskTitle = "상태 관리 리팩토링",
                    taskScript = "복잡한 상태를 효율적으로 관리하기 위한 구조를 설계합니다.",
                    tags = listOf("리팩토링", "상태관리"),
                    nickname = "다이노",
                ),
            ),
        ),
        ProgressCardPreviewModel(
            title = "Done",
            headerColor = CustomColor.Green700,
            bodyColor = CustomColor.Green50,
            borderColor = CustomColor.Green200,
            tasks = listOf<Task>(
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
        ),
    )

}

@Preview(showBackground = true)
@Composable
private fun ProgressCardPreview(
    @PreviewParameter(ProgressCardPreviewProvider:: class)
model:ProgressCardPreviewModel,
) {
    ProgressCard(
        title = model.title, // 헤더:TO DO/In Progress/Done
        headerColor = model.headerColor,
        bodyColor = model.bodyColor,
        borderColor = model.borderColor,
        tasks = model.tasks,
    )
}
