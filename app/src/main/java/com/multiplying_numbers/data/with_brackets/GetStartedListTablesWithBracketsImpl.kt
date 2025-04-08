package com.multiplying_numbers.data.with_brackets

import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.models.Params
import com.multiplying_numbers.domain.models.QuestionAnswer
import com.multiplying_numbers.domain.models.TableParams

class GetStartedListTablesWithBracketsImpl : GetStartedListTablesWithBrackets {
    private enum class Variant {
        VARIANT1,
        VARIANT2,
        VARIANT3,
        VARIANT4,
        VARIANT5,
        VARIANT6,
        VARIANT7,
        VARIANT8,
        VARIANT9,
    }

    override fun getTablesWithBrackets(): List<ModelTabForCard> {
        val list = (2..9).map { table ->
            ModelTabForCard(
                idTable = table,
                listQuestions = (1..10).map { num ->
                    when (Variant.entries.random()) {
                        Variant.VARIANT1 -> getVariant1(table = table, num = num).stringQuestion
                        Variant.VARIANT2 -> getVariant2(table = table, num = num).stringQuestion
                        Variant.VARIANT3 -> getVariant3(table = table, num = num).stringQuestion
                        Variant.VARIANT4 -> getVariant4(table = table, num = num).stringQuestion
                        Variant.VARIANT5 -> getVariant5(table = table, num = num).stringQuestion
                        Variant.VARIANT6 -> getVariant6(table = table, num = num).stringQuestion
                        Variant.VARIANT7 -> getVariant7(table = table, num = num).stringQuestion
                        Variant.VARIANT8 -> getVariant8(table = table, num = num).stringQuestion
                        Variant.VARIANT9 -> getVariant9(table = table, num = num).stringQuestion
                    }

                },
                tableParams = generateTableParamsAddition(idTable = table)
            )
        }
        return list
    }

    private fun generateTableParamsAddition(idTable: Int): TableParams {
        val list = (1..10).map { num ->

            val questionAnswer = when (Variant.entries.random()) {
                Variant.VARIANT1 -> getVariant1(table = idTable, num = num)
                Variant.VARIANT2 -> getVariant2(table = idTable, num = num)
                Variant.VARIANT3 -> getVariant3(table = idTable, num = num)
                Variant.VARIANT4 -> getVariant4(table = idTable, num = num)
                Variant.VARIANT5 -> getVariant5(table = idTable, num = num)
                Variant.VARIANT6 -> getVariant6(table = idTable, num = num)
                Variant.VARIANT7 -> getVariant7(table = idTable, num = num)
                Variant.VARIANT8 -> getVariant8(table = idTable, num = num)
                Variant.VARIANT9 -> getVariant9(table = idTable, num = num)
            }

            Params(
                id = num,
                answerValue = questionAnswer.valueAnswer,
                questionString = questionAnswer.stringQuestion,
                answerString = questionAnswer.stringAnswer
            )
        }
        return TableParams(
            keyStorage = KEY_FOR_STORE + idTable,
            paramsList = list
        )
    }

    /** generate variant for table */
    private fun getVariant1(table: Int, num: Int): QuestionAnswer {
        // 12 + 2 × 2 = ?
        val a = ((table * 10) until (table * 10) + 10).random()
        val b = table
        val c = num
        val valueAnswer = a + b * c
        val question = "%2d +%2d ×%2d = ?".format(a, b, c)
        val answer = "%2d +%2d ×%2d = %2d".format(a, b, c, valueAnswer)
        return QuestionAnswer(
            stringQuestion = question,
            valueAnswer = valueAnswer,
            stringAnswer = answer
        )
    }

    private fun getVariant2(table: Int, num: Int): QuestionAnswer {
        // 12 - 2 × 2 = ?
        val a = ((table * 10) until (table * 10) + 10).random()
        val b = table
        val c = num
        val valueAnswer = a - b * c
        val question = "%2d -%2d ×%2d = ?".format(a, b, c)
        val answer = "%2d -%2d ×%2d = %2d".format(a, b, c, valueAnswer)
        return QuestionAnswer(
            stringQuestion = question,
            valueAnswer = valueAnswer,
            stringAnswer = answer
        )
    }

    private fun getVariant3(table: Int, num: Int): QuestionAnswer {
        // (2 + 2) × 2 = ?
        val randomSubtrahend = (0..table).random()
        val a = table - randomSubtrahend
        val b = randomSubtrahend
        val c = num
        val valueAnswer = (a + b) * c
        val question = "(%1d +%2d)×%2d = ?".format(a, b, c)
        val answer = "(%1d +%2d)×%2d = %2d".format(a, b, c, valueAnswer)
        return QuestionAnswer(
            stringQuestion = question,
            valueAnswer = valueAnswer,
            stringAnswer = answer
        )
    }

    private fun getVariant4(table: Int, num: Int): QuestionAnswer {
        // (12 - 2) × 2 = ?
        val randomAddend = (0..num).random()
        val a = table + randomAddend
        val b = randomAddend
        val c = num
        val valueAnswer = (a - b) * c
        val strungInstruction = if (a > 9) "-" else " -"
        val question = "(%1d$strungInstruction%2d)×%2d = ?".format(a, b, c)
        val answer = "(%1d$strungInstruction%2d)×%2d = %2d".format(a, b, c, valueAnswer)
        return QuestionAnswer(
            stringQuestion = question,
            valueAnswer = valueAnswer,
            stringAnswer = answer
        )
    }

    private fun getVariant5(table: Int, num: Int): QuestionAnswer {
        // 2 × 2 + 12  = ?
        val a = num
        val b = table
        val c = ((table * 10) until (table * 10) + 10).random()
        val valueAnswer = a * b + c
        val question = "%2d ×%2d +%2d = ?".format(a, b, c)
        val answer = "%2d ×%2d +%2d = %2d".format(a, b, c, valueAnswer)
        return QuestionAnswer(
            stringQuestion = question,
            valueAnswer = valueAnswer,
            stringAnswer = answer
        )
    }

    private fun getVariant6(table: Int, num: Int): QuestionAnswer {
        // 2 × 2 - 2  = ?
        val a = table
        val b = num
        val c = (0..(table * num)).random()
        val valueAnswer = a * b - c
        val question = "%2d ×%2d -%2d = ?".format(a, b, c)
        val answer = "%2d ×%2d -%2d = %2d".format(a, b, c, valueAnswer)
        return QuestionAnswer(
            stringQuestion = question,
            valueAnswer = valueAnswer,
            stringAnswer = answer
        )
    }

    private fun getVariant7(table: Int, num: Int): QuestionAnswer {
        // 2 × 2 + 2  = ?
        val a = table
        val b = num
        val c = (0..num).random()
        val valueAnswer = a * b + c
        val question = "%2d ×%2d +%2d = ?".format(a, b, c)
        val answer = "%2d ×%2d +%2d = %2d".format(a, b, c, valueAnswer)
        return QuestionAnswer(
            stringQuestion = question,
            valueAnswer = valueAnswer,
            stringAnswer = answer
        )
    }

    private fun getVariant8(table: Int, num: Int): QuestionAnswer {
        // 2 × (2 + 2)  = ?
        val randomSubtrahend = (0..num).random()
        val a = table
        val b = num - randomSubtrahend
        val c = randomSubtrahend
        val valueAnswer = a * (b + c)
        val strungInstruction = if (b > 9) "+" else " +"
        val question = "%2d ×(%1d$strungInstruction%2d)= ?".format(a, b, c)
        val answer = "%2d ×(%1d$strungInstruction%2d)= %2d".format(a, b, c, valueAnswer)
        return QuestionAnswer(
            stringQuestion = question,
            valueAnswer = valueAnswer,
            stringAnswer = answer
        )
    }

    private fun getVariant9(table: Int, num: Int): QuestionAnswer {
        // 2 × (2 - 2)  = ?
        val randomAddend = (0..num).random()
        val a = table
        val b = num + randomAddend
        val c = randomAddend
        val valueAnswer = a * (b - c)
        val strungInstruction = if (b > 9) "-" else " -"
        val question = "%2d ×(%1d$strungInstruction%2d)= ?".format(a, b, c)
        val answer = "%2d ×(%1d$strungInstruction%2d)= %2d".format(a, b, c, valueAnswer)
        return QuestionAnswer(
            stringQuestion = question,
            valueAnswer = valueAnswer,
            stringAnswer = answer
        )
    }

    /**______________________________________________________________________________________________*/
    companion object {
        private const val KEY_FOR_STORE = "with_brackets"
    }
}