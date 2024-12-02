package com.multiplying_numbers.data.multiple.storage.sharedPref

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.multiplying_numbers.domain.multiple.models.ModelHistory
import com.multiplying_numbers.domain.multiple.models.ModelSingleTab
import com.multiplying_numbers.domain.multiple.models.mapToModel
import javax.inject.Inject

const val TAG = "StorageSharedPrefImpl"

class StorageSharedPrefImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : StorageSharedPref {

    companion object {
        const val MANE_FOR_SHARED = "model for victory"
    }

    override fun saveInStorage(modelSingleTab: ModelSingleTab) {
        val key = modelSingleTab.idTable.toString()

        val modelForSaveInStorage =
            getModelForSaveInStorage(modelSingleTab = modelSingleTab, key = key)
        //convert list to json
        val gson = Gson()
        val json = gson.toJson(modelForSaveInStorage)
        // save json in shared
        sharedPreferences.edit().apply {
            putString(key, json)
            apply()
        }

    }

    override fun getHistoryFromStorage(idTable: Int): ModelHistory? {
        val key = idTable.toString()
        val modelHistory =  getModelFromStorage(key = key)?.mapToModel()
        return modelHistory
    }

    override fun checkHistory(idTable: Int): Boolean {
        return sharedPreferences.contains(idTable.toString())
    }

    /** other method _________________________________________________________________________________*/
    private fun getModelForSaveInStorage(
        modelSingleTab: ModelSingleTab,
        key: String
    ): ModelHistoryStorage {
        val itemHistory = modelSingleTab.mapToModelStorage()

        val modelHistoryFromStorage = getModelFromStorage(key = key)
            ?.let { modelHistory ->
                modelHistory.copy(
                    listHistoryStorage = modelHistory.listHistoryStorage + itemHistory
                )
            }

        val modelHistoryStorage = ModelHistoryStorage(listHistoryStorage = listOf(itemHistory))
        return modelHistoryFromStorage ?: modelHistoryStorage
    }

    private fun getModelFromStorage(key: String): ModelHistoryStorage? {

        val json = sharedPreferences.getString(key, null)
        val gson = Gson()
        val type = object : TypeToken<ModelHistoryStorage>() {}.type
        val modelHistoryStorage: ModelHistoryStorage? = gson.fromJson(json, type)
        return modelHistoryStorage
    }

}