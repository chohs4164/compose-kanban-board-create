package woowacourse.kanban.board.data

data class NewTaskFormData(
    val title: String,
    val description: String,
    val tags: String,
    val selectedStatusIndex: Int,
    val selectedProfileIndex: Int
)
