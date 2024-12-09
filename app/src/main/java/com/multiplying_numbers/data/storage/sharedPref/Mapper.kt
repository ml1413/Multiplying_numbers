package com.multiplying_numbers.data.storage.sharedPref

import com.multiplying_numbers.domain.models.ColorCountWrongAnswer
import com.multiplying_numbers.domain.models.ColorQuestion
import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.models.ModelSingleTab

fun ModelSingleTab.mapToModelStorage(): ItemHistoryStorage {
    val data = System.currentTimeMillis()
    return ItemHistoryStorage(
        date = data,
        listAnswer = listModelQuestions.map { it.mapToStorage() },
        hasWrongAnswer = hasWrongAnswer,
        colorCountWrongAnswer = colorCountWrongAnswer.mapToStorage()
    )
}

private fun ColorCountWrongAnswer.mapToStorage(): ColorCountWrongAnswerStorage {
    return when (this) {
        ColorCountWrongAnswer.COLOR_DEFAULT -> ColorCountWrongAnswerStorage.COLOR_DEFAULT
        ColorCountWrongAnswer.COLOR_WRONG -> ColorCountWrongAnswerStorage.COLOR_WRONG
        ColorCountWrongAnswer.COLOR_CORRECT -> ColorCountWrongAnswerStorage.COLOR_CORRECT
    }
}

fun ModelQuestions.mapToStorage(): ModelQuestionsStorage {
    return ModelQuestionsStorage(
        id = id,
        answerValue = answerValue,
        questionsString = questionsString,
        isAnimated = isAnimated,
        answerString = answerString,
        countWrongAnswer = countWrongAnswer,
        isCorrectAnswer = isCorrectAnswer,
        textForLeftButton = textForLeftButton,
        textForRightButton = textForLeftButton,
        hasErrors = hasErrors,
        colorQuestionStorage = colorQuestion.mapToStorage()
    )
}

private fun ColorQuestion.mapToStorage(): ColorQuestionStorage {
    return when (this) {
        ColorQuestion.COLOR_DEFAULT -> ColorQuestionStorage.COLOR_DEFAULT
        ColorQuestion.COLOR_WRONG -> ColorQuestionStorage.COLOR_WRONG
        ColorQuestion.COLOR_CORRECT -> ColorQuestionStorage.COLOR_CORRECT
    }
}
