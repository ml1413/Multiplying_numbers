package com.multiplying_numbers.domain.models

import com.multiplying_numbers.data.storage.models.ModelItemVictoryStorage
import com.multiplying_numbers.data.storage.models.ModelParameterForSaveStorage
import com.multiplying_numbers.data.storage.models.ModelQuestionsStorage

fun ModelParameterForSave.mapToModelStorage(): ModelParameterForSaveStorage {
    return ModelParameterForSaveStorage(
        listModelItemVictoryStorage = listModelItemVictory.map { it.mapToModelStorage() }
    )
}

private fun ModelItemVictory.mapToModelStorage(): ModelItemVictoryStorage {
    return ModelItemVictoryStorage(
        keyNameTable = keyNameTable,
        label = label,
        date = date,
        hasWrongAnswer = hasWrongAnswer,
        listAnswerStorage = listAnswer.map { it.mapToModelStorage() }
    )
}

private fun ModelQuestions.mapToModelStorage(): ModelQuestionsStorage {
    return ModelQuestionsStorage(
        id = id,
        factor = factor,
        num = num,
        isAnimation = isAnimation,
        countWrongAnswer = countWrongAnswer,
        questions = questions,
        answer = answer,
        isCorrect = isCorrect,
        correctAnswer = correctAnswer
    )
}