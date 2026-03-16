package woowacourse.kanban.board.component.newTaskCreate

fun validateTitle(value: String?): String? {
    if (value.isNullOrEmpty() || value.isBlank()) return "제목을 입력해 주세요."
    return null
}

fun validateDescription(value: String): String? = null

fun validateTagsAndWordCount(value: String): String? {
    if (value.isBlank()) return null

    val rawTags = value.split(",")

    if (rawTags.any { it.isBlank() }) {
        return "태그 형식이 올바르지 않습니다."
    }

    val tags = rawTags.map { it.trim() }

    if (tags.size > 5) {
        return "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
    }

    if (tags.any { it.length > 5 }) {
        return "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
    }

    return null
}