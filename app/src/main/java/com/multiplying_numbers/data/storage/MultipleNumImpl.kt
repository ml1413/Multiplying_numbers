package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ColorCountWrongAnswer
import com.multiplying_numbers.domain.models.ColorItem
import com.multiplying_numbers.domain.models.ModelItemTab
import com.multiplying_numbers.domain.models.ModelQuestions

private const val TAG = "MultipleNumREFACTORImpl"

class MultipleNumImpl : MultipleNum {
    override fun getListTables(idTable: Int): ModelItemTab {

        val listModelQuestions = (1..10).map { num ->
            val answer = idTable * num

            val leftAndRightAnswer = listOf(answer, answer + (1..3).random()).shuffled()

            val questions = "$idTable  *  $num  =  ?"
            val answerString = "$idTable  *  $num  = $answer"


            ModelQuestions(
                id = num,
                answerValue = answer,
                questionsString = questions,
                answerString = answerString,
                textForLeftButton = leftAndRightAnswer[0],
                textForRightButton = leftAndRightAnswer[1]
            )
        }
        val randomModelQuestion = listModelQuestions.random()
        return ModelItemTab(
            idTable = idTable,
            idQuestion = randomModelQuestion.id,
            listModelQuestions = listModelQuestions,
            answerValue = randomModelQuestion.answerValue,
            questionString = randomModelQuestion.questionsString,
            textForLeftButton = randomModelQuestion.textForLeftButton,
            textForRightButton = randomModelQuestion.textForRightButton
        )
    }


    override fun checkLeftAnswer(modelItemTab: ModelItemTab): ModelItemTab {

        return checkAnswer(
            modelItemTab = modelItemTab,
            answer = modelItemTab.textForLeftButton
        )
    }

    override fun checkRightAnswer(modelItemTab: ModelItemTab): ModelItemTab {
        return checkAnswer(
            modelItemTab = modelItemTab,
            answer = modelItemTab.textForRightButton
        )
    }

    /** otherfun__________________________________________________________________________________*/

    private fun checkAnswer(
        modelItemTab: ModelItemTab,
        answer: Int
    ): ModelItemTab {

        val listModelQuestions = modelItemTab.listModelQuestions
            .map { modelQuestion ->
                when {
                    // change item  answer and color if answer is correct
                    modelQuestion.id == modelItemTab.idQuestion && modelQuestion.answerValue == answer ->
                        modelQuestion.copy(
                            questionsString = modelQuestion.questionsString
                                .replace("?", "$answer"),
                            isCorrectAnswer = true,
                            isAnimated = true,
                            colorItem = ColorItem.COLOR_CORRECT
                        )
                    // if answer is not correct change count wrong answer and color
                    modelQuestion.id == modelItemTab.idQuestion && modelQuestion.answerValue != answer ->
                        modelQuestion.copy(
                            countWrongAnswer = modelQuestion.countWrongAnswer + 1,
                            isAnimated = true,
                            colorItem = ColorItem.COLOR_WRONG
                        )

                    else -> modelQuestion.copy(isAnimated = false)
                }
            }

        val modelForQuestions = listModelQuestions
            .filterNot { it.isCorrectAnswer }
            .shuffled()
            .firstOrNull()

        return modelItemTab.let { modelTable ->
            val sumCountWrongAnswer = listModelQuestions.sumOf { it.countWrongAnswer }
            modelTable.copy(
                idQuestion = modelForQuestions?.id ?: modelTable.idQuestion,
                listModelQuestions = listModelQuestions,
                hasWrongAnswer = sumCountWrongAnswer > 0,
                colorCountWrongAnswer = when {
                    sumCountWrongAnswer > 0 -> ColorCountWrongAnswer.COLOR_WRONG
                    sumCountWrongAnswer == 0 && modelForQuestions == null -> ColorCountWrongAnswer.COLOR_CORRECT
                    else -> ColorCountWrongAnswer.COLOR_DEFAULT
                },
                isAllAnswerCorrect = modelForQuestions == null,
                isPrintCountWrongAnswer = sumCountWrongAnswer > modelTable.countWrongAnswer || sumCountWrongAnswer == 0 && modelForQuestions == null,
                questionString = modelForQuestions?.questionsString ?: "",
                answerValue = modelForQuestions?.answerValue ?: modelTable.answerValue,
                countWrongAnswer = listModelQuestions.sumOf { it.countWrongAnswer },
                textForLeftButton = modelForQuestions?.textForLeftButton
                    ?: modelTable.textForLeftButton,
                textForRightButton = modelForQuestions?.textForRightButton
                    ?: modelTable.textForRightButton
            )
        }
    }
}

