package woowacourse.kanbanboard.newTaskCreate.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanbanboard.board.CustomColor

@Composable
fun CreateNewTaskDialogOverlay(onDismiss: () -> Unit) {
    Box(
        modifier = Modifier
            .size(1294.dp, 909.dp)
            .background(CustomColor.Gray800.copy(alpha = 0.61f))
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center,

        ) {
        CreateNewTaskDialog(onDismiss = onDismiss)
    }
}

@Preview(showBackground = true, widthDp = 1294, heightDp = 909)
@Composable
private fun CreateNewTaskDialogOverlayPreivew() {
    CreateNewTaskDialogOverlay(onDismiss = {})
}