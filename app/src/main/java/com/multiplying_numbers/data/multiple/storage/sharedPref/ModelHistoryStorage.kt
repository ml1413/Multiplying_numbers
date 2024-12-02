package com.multiplying_numbers.data.multiple.storage.sharedPref

data class ModelHistoryStorage(
    val listHistoryStorage: List<ItemHistoryStorage> = emptyList()
)

data class ItemHistoryStorage(
    val hasWrongAnswer: Boolean,
    val label: Int,
    val date: Long,
    val listAnswer: List<ModelQuestionsStorage>,
    val colorCountWrongAnswer: ColorCountWrongAnswerStorage = ColorCountWrongAnswerStorage.COLOR_DEFAULT
)
data class ModelQuestionsStorage(
    val id: Int,
    val answerValue: Int,
    val questionsString: String,
    val isAnimated: Boolean = false,
    val answerString: String,
    val countWrongAnswer: Int = 0,
    val isCorrectAnswer: Boolean = false,
    val textForLeftButton: Int,
    val textForRightButton: Int,
    val hasErrors: Boolean = false,
    val colorQuestionStorage: ColorQuestionStorage = ColorQuestionStorage.COLOR_DEFAULT
)
enum class ColorCountWrongAnswerStorage {
    COLOR_DEFAULT, COLOR_WRONG, COLOR_CORRECT
}
enum class ColorQuestionStorage {
    COLOR_DEFAULT, COLOR_WRONG, COLOR_CORRECT
}