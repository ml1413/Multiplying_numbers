package com.multiplying_numbers.data.storage

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.multiplying_numbers.domain.models.ModelLabelResultAnswer
import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.models.ModelWrapper

class StorageListResultSharedImpl(private val context: Context) : StorageListResult {
    private val sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    override fun saveList(listResult: List<ModelWrapper>, keyName: String) {

        //convert list to json
        val gson = Gson()
        val json = gson.toJson(listResult)
        // save json in shared
        sharedPreferences.edit().apply {
            putString(keyName, json)
            apply()
        }
    }

    override fun getList(keyName: String): List<ModelWrapper>? {
        val json = sharedPreferences.getString(keyName, null) ?: return null
        // parse json to list element
        val jsonArray = JsonParser.parseString(json).asJsonArray
        val models = mutableListOf<ModelWrapper>()
        val gson = Gson()
        //convert single element to correct type
        for (element in jsonArray) {
            val obj = element.asJsonObject
            //______________________________________________________________________________________
            val modelQuestionsName = "modelQuestions"
            if (obj.has(modelQuestionsName)) {
                val modelQuestions =
                    gson.fromJson(obj.get(modelQuestionsName), ModelQuestions::class.java)
                models.add(ModelWrapper.ModelQuestion(modelQuestions = modelQuestions))
            }
            //______________________________________________________________________________________
            val modelLabelResultAnswerName = "modelLabelResultAnswer"
            if (obj.has(modelLabelResultAnswerName)) {
                val modelLabelResultAnswer =
                    gson.fromJson(
                        obj.get(modelLabelResultAnswerName),
                        ModelLabelResultAnswer::class.java
                    )
                models.add(ModelWrapper.ModelLabel(modelLabelResultAnswer = modelLabelResultAnswer))
            }
        }
        return models
    }

    companion object {
        private const val SHARED_NAME = "name"
    }
}