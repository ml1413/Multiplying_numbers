package com.multiplying_numbers.data.storage.models

import android.util.Log
import com.multiplying_numbers.domain.models.ModelItemVictory
import com.multiplying_numbers.domain.models.ModelParameterForSave
import com.multiplying_numbers.domain.models.ModelQuestions
private const val TAG = "MapperFromSharedToModel"
fun ModelParameterForSaveStorage.mapToModel(): ModelParameterForSave {
    Log.i(TAG, "mapToModel:ModelParameterForSaveStorage $this ")
    return ModelParameterForSave(
        listModelItemVictory = listModelItemVictoryStorage.map { it.mapToModel() }
    )
}

private fun ModelItemVictoryStorage.mapToModel(): ModelItemVictory {
    return ModelItemVictory(
        keyNameTable = keyNameTable,
        label = label,
        date = date,
        hasWrongAnswer = hasWrongAnswer,
        listAnswer = listAnswerStorage.map { it.mapToModel() }
    )
}

private fun ModelQuestionsStorage.mapToModel(): ModelQuestions {
    return ModelQuestions(
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