package com.multiplying_numbers.domain.models

import com.multiplying_numbers.data.storage.sharedPref.ColorQuestionStorage
import com.multiplying_numbers.data.storage.sharedPref.ItemHistoryStorage
import com.multiplying_numbers.data.storage.sharedPref.ModelHistoryStorage
import com.multiplying_numbers.data.storage.sharedPref.ModelQuestionsStorage

fun ModelHistoryStorage.mapToModel(): ModelHistory {
    return ModelHistory(
        listHistory = listHistoryStorage.map {
            it.mapToModel()
        }
    )
}

private fun ItemHistoryStorage.mapToModel(): ItemHistory {
    return ItemHistory(
        hasWrongAnswer = hasWrongAnswer,
        date = date,
        listAnswer = listAnswer.map { it.mapToModel() }
    )
}

private fun ModelQuestionsStorage.mapToModel(): ModelQuestions {
    return ModelQuestions(
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
        colorQuestion = colorQuestionStorage.mapToModel()
    )
}

private fun ColorQuestionStorage.mapToModel(): ColorQuestion {
    return when (this) {
        ColorQuestionStorage.COLOR_DEFAULT -> ColorQuestion.COLOR_DEFAULT
        ColorQuestionStorage.COLOR_WRONG -> ColorQuestion.COLOR_WRONG
        ColorQuestionStorage.COLOR_CORRECT -> ColorQuestion.COLOR_CORRECT
    }
}
