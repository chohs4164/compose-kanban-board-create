package woowacourse.kanban.board.component.newTaskCreate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.task.ProfileCard

@Composable
fun NewTaskForm(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    tags: String,
    onTagsChange: (String) -> Unit,
    selectedStatusIndex: Int,
    onStatusChange: (Int) -> Unit,
    selectedProfileIndex: Int,
    onProfileChange: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            textFieldTag = "title_textField",
            titleText = "제목 *",
            value = title,
            onValueChange = onTitleChange,
            hintText = "태스크 제목을 입력하세요",
            defaultSupportingText = "",
            validate = {
                validateTitle(it)
            },
            minLines = 1,
            maxLines = 1
        )
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            textFieldTag = "description_textField",
            titleText = "설명",
            value = description,
            onValueChange = onDescriptionChange,
            hintText = "태스크에 대한 자세한 설명을 입력하세요",
            defaultSupportingText = null,
            validate = { validateDescription(it) },
            minLines = 6,
            maxLines = 6,
        )
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            textFieldTag = "tags_textField",
            titleText = "태그",
            value = tags,
            onValueChange = onTagsChange,
            hintText = "태그를 쉼표로 구분하여 입력하세요 (예: 버그, 긴급)",
            defaultSupportingText = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다.",
            validate = { validateTagsAndWordCount(it) },
            minLines = 1,
            maxLines = 1
        )
        ItemSelectionFormBox(
            text = "상태 *",
            selectedItemIndex = selectedStatusIndex,
            onItemSelected = onStatusChange,
            width = 200.dp,
            height = 52.dp,
            { Text("To Do", modifier = Modifier.align(Alignment.Center)) },
            { Text("In Progress", modifier = Modifier.align(Alignment.Center)) },
            { Text("Done", modifier = Modifier.align(Alignment.Center)) },
        )
        ItemSelectionFormBox(
            text = "담당자 *", selectedProfileIndex,
            onItemSelected = onProfileChange,
            width = 200.dp,
            height = 68.dp,
            { ProfileCard("다이노", modifier = Modifier.align(Alignment.CenterStart)) },
            { ProfileCard("페임스", modifier = Modifier.align(Alignment.CenterStart)) },
        )
    }
}

@Preview(widthDp = 672, heightDp = 818)
@Composable
private fun NewTaskFormPreview() {
    var title by remember { mutableStateOf("태스크 제목을 입력하세요") }
    var description by remember { mutableStateOf("태스크에 대한 자세한 설명을 입력하세요") }
    var tags by remember { mutableStateOf("태그를 쉼표로 구분하여 입력하세요 (예: 버그,긴급)") }
    var selectedStatusIndex by remember { mutableStateOf(0) }
    var selectedProfileIndex by remember { mutableStateOf(0) }

    NewTaskForm(
        title = title,
        onTitleChange = { title = it },
        description = description,
        onDescriptionChange = { description = it },
        tags = tags,
        onTagsChange = { tags = it },
        selectedStatusIndex = selectedStatusIndex,
        onStatusChange = { selectedStatusIndex = it },
        selectedProfileIndex = selectedProfileIndex,
        onProfileChange = { selectedProfileIndex = it },
    )
}
