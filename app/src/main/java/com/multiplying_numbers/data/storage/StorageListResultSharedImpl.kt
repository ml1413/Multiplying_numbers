package com.multiplying_numbers.data.storage

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.multiplying_numbers.data.storage.models.ModelParameterForSaveStorage
import com.multiplying_numbers.data.storage.models.mapToModel
import com.multiplying_numbers.domain.models.ModelParameterForSave
import com.multiplying_numbers.domain.models.mapToModelStorage
import javax.inject.Inject

private const val TAG = "StorageListResultSharedImpl"

class StorageListResultSharedImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : StorageListResult {
    //    private val sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    override fun save(modelParameterForSave: ModelParameterForSave, keyName: String) {
        val modelParameterForSaveStorage = modelParameterForSave.mapToModelStorage()
        //convert list to json
        val gson = Gson()
        val json = gson.toJson(modelParameterForSaveStorage)
        // save json in shared
        sharedPreferences.edit().apply {
            putString(keyName, json)
            apply()
        }
    }

    override fun get(keyName: String): ModelParameterForSave? {
        val json = sharedPreferences.getString(keyName, null) ?: return null
        val gson = Gson()
        val type = object : TypeToken<ModelParameterForSaveStorage>() {}.type
        val modelFromStorage: ModelParameterForSaveStorage? = gson.fromJson(json, type)
        Log.i(TAG, "get: modelFromStorage $modelFromStorage")
        val modelParameterForSave = modelFromStorage?.mapToModel()
        return modelParameterForSave
    }

    companion object {
        const val SHARED_NAME = "name"
    }
}