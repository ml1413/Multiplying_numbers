package com.multiplying_numbers.data.multiple

import com.multiplying_numbers.domain.multiple.models.ColorCountWrongAnswer
import com.multiplying_numbers.domain.multiple.models.ColorQuestion
import com.multiplying_numbers.domain.multiple.models.ModelQuestions
import com.multiplying_numbers.domain.multiple.models.ModelSingleTab
import com.multiplying_numbers.domain.multiple.models.TableParams
import javax.inject.Inject


class SingleTableInterfaceImpl @Inject constructor(
    private val signal: WrongAnswerSignal
) : SingleTableInterface {
    override fun getListTables(tableParams: TableParams): ModelSingleTab {

        val listModelQuestions = tableParams.paramsList.map { params ->
            val leftAndRightAnswer = listOf(
                params.answerValue, params.answerValue + (1..3).random()
            ).shuffled()

            ModelQuestions(
                id = params.id,
                answerValue = params.answerValue,
                questionsString = params.questionString,
                answerString = params.answerString,
                textForLeftButton = leftAndRightAnswer[0],
                textForRightButton = leftAndRightAnswer[1]
            )
        }
        val randomModelQuestion = listModelQuestions.random()
        return ModelSingleTab(
            idTable = tableParams.idTable,
            keyStorage = tableParams.keyStorage,
            idQuestion = randomModelQuestion.id,
            listModelQuestions = listModelQuestions,
            answerValue = randomModelQuestion.answerValue,
            questionString = randomModelQuestion.questionsString,
            textForLeftButton = randomModelQuestion.textForLeftButton,
            textForRightButton = randomModelQuestion.textForRightButton
        )
    }


    override fun checkLeftAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab {

        return checkAnswer(
            modelSingleTab = modelSingleTab,
            answer = modelSingleTab.textForLeftButton
        )
    }

    override fun checkRightAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab {
        return checkAnswer(
            modelSingleTab = modelSingleTab,
            answer = modelSingleTab.textForRightButton
        )
    }

    /** otherfun__________________________________________________________________________________*/

    private fun checkAnswer(
        modelSingleTab: ModelSingleTab,
        answer: Int
    ): ModelSingleTab {

        val listModelQuestions =
            setAnswerInModelAndgetListModelQuestions(
                modelSingleTab = modelSingleTab,
                answer = answer
            )

        val modelForQuestions =
            getRandomModelForNextQuestion(listModelQuestions = listModelQuestions)

        return getSingleTabModel(
            modelSingleTab = modelSingleTab,
            listModelQuestions = listModelQuestions,
            modelForQuestions = modelForQuestions
        )
    }

    private fun getSingleTabModel(
        modelSingleTab: ModelSingleTab,
        listModelQuestions: List<ModelQuestions>,
        modelForQuestions: ModelQuestions?
    ): ModelSingleTab {
        modelSingleTab.let { modelTable ->
            val sumCountWrongAnswer = listModelQuestions.sumOf { it.countWrongAnswer }
            return modelTable.copy(
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

    private fun setAnswerInModelAndgetListModelQuestions(
        modelSingleTab: ModelSingleTab,
        answer: Int
    ): List<ModelQuestions> {
        val listModelQuestions = modelSingleTab.listModelQuestions
            .map { modelQuestion ->
                when {
                    // change item  answer and color if answer is correct
                    modelQuestion.id == modelSingleTab.idQuestion && modelQuestion.answerValue == answer ->
                        setValueInModelIfAnswerCorrect(modelQuestion, answer)
                    // if answer is not correct change count wrong answer and color
                    modelQuestion.id == modelSingleTab.idQuestion && modelQuestion.answerValue != answer -> {
                        signal.signal()
                        setValueInModelIfAnswerWrong(modelQuestion)
                    }

                    else -> modelQuestion.copy(isAnimated = false)
                }
            }
        return listModelQuestions
    }

    private fun getRandomModelForNextQuestion(listModelQuestions: List<ModelQuestions>): ModelQuestions? {
        val modelForQuestions = listModelQuestions
            .filterNot { it.isCorrectAnswer }
            .shuffled()
            .firstOrNull()
        return modelForQuestions
    }

    private fun setValueInModelIfAnswerCorrect(
        modelQuestion: ModelQuestions,
        answer: Int
    ) = modelQuestion.copy(
        questionsString = modelQuestion.answerString,
        isCorrectAnswer = true,
        isAnimated = true,
        colorQuestion = ColorQuestion.COLOR_CORRECT,
    )

    private fun setValueInModelIfAnswerWrong(modelQuestion: ModelQuestions) =
        modelQuestion.copy(
            countWrongAnswer = modelQuestion.countWrongAnswer + 1,
            isAnimated = true,
            colorQuestion = ColorQuestion.COLOR_WRONG,
            hasErrors = true
        )
}