package woowacourse.kanban.board.component.newTaskCreate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CreateNewTaskDialog() {
    // 제목부분
    var titleText by remember { mutableStateOf("") }
    // 텍스트 필드의 내용 부분
    var description by remember { mutableStateOf("") }
    // 태그의 내용 부분
    var tags by remember { mutableStateOf("") }
    // 상태 부분의 선택된 버튼 인덱스
    var selectedStatusIndex by remember { mutableStateOf(0) }
    // 프로필 부분의 선택된 버튼 인덱스
    var selectedProfileIndex by remember { mutableStateOf(0) }
    // 유효성 검사 통과 유무에 따른 생성 버튼 활성 상태 부분
    val isCreateEnabled by remember(titleText, tags) {
        derivedStateOf {
            (validateTitle(titleText) == null) && (validateTagsAndWordCount(tags) == null)
        }
    }

    Column {
        // 상단부
        TopBar()
        HorizontalDivider()
        // 중단부
        NewTaskForm(
            title = titleText,
            onTitleChange = { titleText = it },
            description = description,
            onDescriptionChange = { description = it },
            tags = tags,
            onTagsChange = { tags = it },
            selectedStatusIndex = selectedStatusIndex,
            onStatusChange = { selectedStatusIndex = it },
            selectedProfileIndex = selectedProfileIndex,
            onProfileChange = { selectedProfileIndex = it },
        )
        HorizontalDivider(Modifier.padding(24.dp))
        // 하단부
        Box(modifier = Modifier.padding(vertical = 16.dp)) {
            CreateNewTaskDialogBottom(isCreateEnabled = isCreateEnabled)
        }
    }
}

@Preview(widthDp=672, heightDp = 818)
@Composable
fun CreateNewTaskDialogPreview(
) {
    CreateNewTaskDialog()
}
