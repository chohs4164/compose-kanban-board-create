//package woowacourse.kanban.board
//
//import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle
//import org.assertj.core.api.Assertions.assertThatThrownBy
//import kotlin.test.Test
//
//
//enum class TaskStatus() {
//    TODO, INPROGRESS, DONE
//}
//
//class Task(
//    val title: String,
//    val description: String? = null,
//    val tags: List<String> = emptyList(),
//    val status: TaskStatus = TaskStatus.TODO,
//    val assignee: String
//) {
//
//    fun doesDescriptionExists() = description != null
//
//    init {
//        require(HtmlStyle.title.isNotEmpty()) { "제목은 빈 문자열일 수 없습니다." }
//        require(tags.size ?: 0 <= 5) { "태그는 5개까지만 생성 가능합니다." }
//    }
//}
//
//class TastTest {
//
//    @Test
//    fun `태스크는 제목, 설명, 태그, 상태, 담당자를 가진다`() {
//        val task = Task(
//            title = "TDD 수업하기",
//            description = "오늘 배운 내용을 복습하고 다음 주제를 준비한다.",
//            tags = listOf("공부", "TDD"),
//            status = TaskStatus.TODO,
//            assignee = "레아"
//        )
//
//        asserThat(task.title).isEqualTo("TDD 수업하기")
//        asserThat(task.description).isEqualTo("TDD 수업하기")
//        asserThat(task.tags).isEqualTo("TDD 수업하기")
//        asserThat(task.status).isEqualTo("TDD 수업하기")
//        asserThat(task.assignee).isEqualTo("TDD 수업하기")
//    }
//
//    @Test
//    fun `제목이 빈 문자열이면 태스크 생성이 불가능하다`() {
//        assertThatThrownBy {
//            val task = Task(
//                title = " ",
//                description = "오늘 배운 내용을 복습하고 다음 주제를 준비한다.",
//                tags = listOf("공부", "TDD"),
//                status = TaskStatus.TODO,
//                assignee = "레아"
//            )
//        }.isInstanceOf(IllegalArgumentException::class.java)
//    }
//
//    @Test
//    fun `태그는 최대 5개까지 생성이 가능하다`() {
//
//        assertThatThrownBy {
//            val task = Task(
//                title = "TDD 수업하기",
//                description = "오늘 배운 내용을 복습하고 다음 주제를 준비한다.",
//                tags = listOf("공부", "TDD", "TDD1", "TDD2", "TDD3", "TDD4"),
//                status = TaskStatus.TODO,
//                assignee = "레아"
//            )
//        }.isInstanceOf(IllegalArgumentException::class.java)
//    }
//
//    @Test
//    fun `제목, 상태, 담당자로 태스크를 생성할 수 있다`() {
//        val task = Task(
//            title = "TDD 수업하기",
//            status = TaskStatus.TODO,
//            assignee = "레아",
//        )
//        asserThat(task.title).isEqualTo("TDD 수업하기")
//        asserThat(task.status).isEqualTo(TaskStatus.TODO)
//        asserThat(task.assignee).isEqualTo("레아")
//        assertThat(task.doesDescriptionExists()).isEqualsTo("")
//    }
//
//    @Test
//    fun `상태를 지정하지 않으면 기본값은 TODO이다`() {
//        val task = Task(
//            title = "TDD 수업하기",
//            status = TaskStatus.TODO,
//            assignee = "레아",
//        )
//        asserThat(task.title).isEqualTo("TDD 수업하기")
//        asserThat(task.status).isEqualTo(TaskStatus.TODO)
//        asserThat(task.assignee).isEqualTo("레아")
//        assertThat(task.doesDescriptionExists()).isEqualsTo("")
//    }
//    @Test
//    fun `상태를 지정하지 않으면 기본값은 TODO이다`() {
//        val task = Task(
//            title = "TDD 수업하기",
//            status = TaskStatus.TODO,
//            assignee = "레아",
//        )
//        asserThat(task.title).isEqualTo("TDD 수업하기")
//        asserThat(task.status).isEqualTo(TaskStatus.TODO)
//        asserThat(task.assignee).isEqualTo("레아")
//        assertThat(task.doesDescriptionExists()).isEqualsTo("")
//    }
//}