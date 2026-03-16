//package woowacourse.kanban.board
//
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.testTag
//import androidx.compose.ui.test.ExperimentalTestApi
//import androidx.compose.ui.test.onNodeWithText
//import androidx.compose.ui.test.runComposeUiTest
//import kotlin.test.Test
//
//class UsernameTextFieldTest {
//
//    @OptIn(ExperimentalTestApi::class)
//    @Test
//    fun test1() = runComposeUiTest{
//        setContent{
//            var username by mutableStateOf("")
//            val isError = ""
//            TextField(
//                value = username,
//                onValueChange = {username = it},
//                isError = isError,
//                supportingText = {
//                    if(isError){
//                        Text("에러 메시지", modifier = Modifier.testTag("error"))
//                    }
//                }
//            )
//        }
//        // when: 사용자가 "김컴포즈"라는 문자열을 입력한다.
//        username = "김컴포즈"
//        // then: 에러 메시지가 보여져서는 안된다.
//        onNodeWithText("에러 메시지").assertDoesNotExist()
//    }
//
//    @Test
//    fun tset2() = runComposeUiTest {
//        // given: 이름 초깃값은 빈 문자열 이다.
//        // when: 사용자가 "김컴포즈입니다"라는 문자열을 입력한다.
//        // then: "이름은 2~5자여야 합니다."라는 에러 메시지가 노출된다.
//    }
//}