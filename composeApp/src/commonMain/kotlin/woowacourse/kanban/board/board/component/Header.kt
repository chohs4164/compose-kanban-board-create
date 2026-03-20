package woowacourse.kanban.board.board.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.CustomColor
import woowacourse.kanban.board.component.newTaskCreate.BottomButton
import java.awt.SystemColor.text

@Composable
fun Header(
    totalCount: Int,
    doneCount: Int,
) {
    Column(
        modifier = Modifier
            .size(
                width = 1295.dp,
                height = 113.dp,
            )
            .border(width = 1.dp, color = CustomColor.Gray200)
            .padding(
                top = 16.dp,
                bottom = 17.dp,
                start = 24.dp,
                end = 24.dp,
            ),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Compose Desk 칸반 보드",
                    color = CustomColor.Gray900,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    // 완료율에 전체 task수와 done수를 받아와야함
                    text = "완료율: ${((doneCount.toDouble() / totalCount) * 100).toInt()}% (${doneCount}/${totalCount})",
                    color = CustomColor.Gray500,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
            BottomButton(
                text = "+ 새 태스크 생성",
                textColor = Color.White,
                backgroundColor = CustomColor.Violet600,
                enabled = true,
                onClick = {},
            )
        }
        val progress = if (totalCount == 0) 0f else doneCount.toFloat() / totalCount.toFloat()

        LinearProgressIndicator(
            gapSize = 0.dp,
            strokeCap = StrokeCap.Square,
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(100.dp)),
            color = CustomColor.Violet600,
            trackColor = CustomColor.Gray200,
        )
    }
}

@Preview(showBackground = true, widthDp = 1295)
@Composable
private fun HeaderPreview() {
    Header(
        totalCount = 6,
        doneCount = 3,
    )
}
