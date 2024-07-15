package com.multiplying_numbers.domain.models

sealed class ModelWrapper {
    class ModelQuestion( val modelQuestions: ModelQuestions):ModelWrapper()
    class ModelLabel (val modelLabelResultAnswer: ModelLabelResultAnswer):ModelWrapper()
}