package woowacourse.kanbanboard.newTaskCreate.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ItemSelectionFormBox(
    text: String, //제목, 상태 등등..
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit,
    width: Dp,
    height: Dp,
    vararg createButton: @Composable BoxScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            createButton.forEachIndexed { index, element ->
                DefaultSelectButton(
                    isSelected = (selectedItemIndex == index),
                    width = width,
                    height = height,
                    onClick = { onItemSelected(index) },
                    content = element,
                )
            }
        }
    }
}

@Preview(widthDp = 672)
@Composable
private fun ItemSelectionFormBoxPreview() {
    val elevation: ButtonElevation? = ButtonDefaults.buttonElevation(
        defaultElevation = 10.dp,
        pressedElevation = 0.dp,
        disabledElevation = 0.dp,
    )
    Column {
        ItemSelectionFormBox(
            text = "상태 *",
            selectedItemIndex = 0,
            onItemSelected = { },
            width = 200.dp,
            height = 52.dp,
            { Text("Hello1", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("Hello2", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("Hello3", modifier = Modifier.align(Alignment.CenterStart)) },
        )
        ItemSelectionFormBox(
            text = "상태 *",
            selectedItemIndex = 0,
            onItemSelected = { },
            width = 200.dp,
            height = 68.dp,
            { Text("Hello", modifier = Modifier.align(Alignment.Center)) },
        )
    }
}
