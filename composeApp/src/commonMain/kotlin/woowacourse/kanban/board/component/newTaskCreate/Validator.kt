package woowacourse.kanban.board.component.newTaskCreate

fun validateTitle(value: String?): String? {
    if (value.isNullOrEmpty() || value.isBlank()) return "제목을 입력해 주세요."
    return null
}

fun validateDescription(value: String): String? = null

fun validateTagsAndWordCount(value: String): String? {
    if (value.isBlank()) return null

    val tags = value.split(',').map { it.trim() }
    if (tags.size !in 0..5) return "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
    tags.forEach { tag ->
        if (tag.length !in 1..5) return "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
    }
    return null
}