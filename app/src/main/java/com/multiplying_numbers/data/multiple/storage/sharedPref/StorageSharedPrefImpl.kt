package com.multiplying_numbers.data.multiple.storage.sharedPref

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.multiplying_numbers.domain.multiple.models.ItemHistory
import com.multiplying_numbers.domain.multiple.models.ModelHistory
import com.multiplying_numbers.domain.multiple.models.ModelSingleTab
import javax.inject.Inject

class StorageSharedPrefImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : StorageSharedPref {

    companion object {
        const val MANE_FOR_SHARED = "model for victory"
    }

    override fun saveInStorage(modelSingleTab: ModelSingleTab) {
        // todo need mapping
        val key = modelSingleTab.idTable.toString()
        val data = System.currentTimeMillis()


        val itemHistory = ItemHistory(
            label = modelSingleTab.idTable,
            date = data,
            listAnswer = modelSingleTab.listModelQuestions,
            hasWrongAnswer = modelSingleTab.hasWrongAnswer,
            colorCountWrongAnswer = modelSingleTab.colorCountWrongAnswer
        )
        val modelHistoryFromStorage = getModelFromStorage(key = key)
            ?.let { modelHistory ->
                modelHistory.copy(
                    listHistory = modelHistory.listHistory + itemHistory
                )
            }

        val modelHistory = ModelHistory(listHistory = listOf(itemHistory))

        //convert list to json
        val gson = Gson()
        val json = gson.toJson(modelHistoryFromStorage ?: modelHistory)
        // save json in shared
        sharedPreferences.edit().apply {
            putString(key, json)
            apply()
        }

    }

    override fun getHistoryFromStorage(idTable: Int): ModelHistory? {
        val key = idTable.toString()
        return getModelFromStorage(key = key)
    }

    override fun checkHistory(idTable: Int): Boolean {
       return sharedPreferences.contains(idTable.toString())
    }
    //todo  need add fun get from storage

    private fun getModelFromStorage(key: String): ModelHistory? {
        //todo need map
        val json = sharedPreferences.getString(key, null)
        val gson = Gson()
        val type = object : TypeToken<ModelHistory>() {}.type
        val modelHistory: ModelHistory? = gson.fromJson(json, type)
        return modelHistory
    }

}