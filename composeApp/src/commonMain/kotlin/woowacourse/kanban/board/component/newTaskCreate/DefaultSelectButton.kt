package woowacourse.kanban.board.component.newTaskCreate

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.outlinedButtonColors
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.CustomColor
import woowacourse.kanban.board.component.task.ProfileCard

@Composable
fun DefaultSelectButton(
    isSelected: Boolean,
    width: Dp,
    height: Dp,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.size(width, height),
        colors = outlinedButtonColors(
            containerColor = if (isSelected) CustomColor.blue50 else Color.Transparent,
            contentColor = if (isSelected) CustomColor.blue700 else CustomColor.gray700,
        ),
        border = BorderStroke(
            width = 2.dp,
            color = if (isSelected) CustomColor.blue700
            else CustomColor.gray400,
        ),
    ) {
        Box(
            modifier = Modifier
                .width(200.dp),
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun DefaultSelectButtonPreview() {
    Column {
        DefaultSelectButton(
            isSelected = false,
            width = 200.dp,
            height = 52.dp,
            onClick = {},
            content = { Text("Hello", modifier = Modifier.align(Alignment.CenterStart)) })
        DefaultSelectButton(
            isSelected = false,
            width = 200.dp,
            height = 52.dp,
            onClick = {},
            content = { Text("조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘") })
        DefaultSelectButton(
            isSelected = false,
            width = 200.dp,
            height = 52.dp,
            onClick = {},
            content = { Text("To Do", modifier = Modifier.align(Alignment.Center)) })
        DefaultSelectButton(
            isSelected = false,
            width = 200.dp,
            height = 52.dp,
            onClick = {},
            content = { Text("In Progress") })
        DefaultSelectButton(
            isSelected = false,
            width = 200.dp,
            height = 68.dp,
            onClick = {},
            content = { ProfileCard("조디악", Modifier.align(Alignment.CenterStart)) })
    }
}
