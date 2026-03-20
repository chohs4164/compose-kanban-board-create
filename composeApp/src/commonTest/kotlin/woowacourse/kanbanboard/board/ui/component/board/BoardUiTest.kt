package woowacourse.kanbanboard.board.ui.component.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

class BoardUiTest {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `새 태스크 생성 버튼을 누르면 새 태스크 생성 Dialog 화면이 뜬다`() = runComposeUiTest {
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `새 태스크를 생성함에 따라 완료율의 숫자가 변경되고 Progress Indicator의 비율도 변경된다`() = runComposeUiTest {
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `새 태스크를 생성함에 따라 To Do 쪽 칸반 보드에 taskCard가 추가되고 숫자가 늘어난다`() = runComposeUiTest {

    }
    
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `새 태스크 생성함에 따라 SnackBar가 뜬다`() = runComposeUiTest {

    }

}