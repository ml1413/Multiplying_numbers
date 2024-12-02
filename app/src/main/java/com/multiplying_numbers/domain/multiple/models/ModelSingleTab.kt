package com.multiplying_numbers.domain.multiple.models

data class ModelSingleTab(
    val idTable: Int,
    val idQuestion: Int,
    val hasWrongAnswer: Boolean = false,
    val isAllAnswerCorrect: Boolean = false,
    val listModelQuestions: List<ModelQuestions>,
    val colorCountWrongAnswer: ColorCountWrongAnswer = ColorCountWrongAnswer.COLOR_DEFAULT,
    val isPrintCountWrongAnswer: Boolean = false,
    val questionString: String,
    val answerValue: Int,
    val textForLeftButton: Int,
    val textForRightButton: Int,
    val countWrongAnswer: Int = 0
)

data class ModelQuestions(
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
    val colorQuestion: ColorQuestion = ColorQuestion.COLOR_DEFAULT
)

enum class ColorCountWrongAnswer {
    COLOR_DEFAULT, COLOR_WRONG, COLOR_CORRECT
}

enum class ColorQuestion {
    COLOR_DEFAULT, COLOR_WRONG, COLOR_CORRECT
}
