package com.multiplying_numbers.data.storage

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.multiplying_numbers.domain.models.ModelParameterForSave

class StorageListResultSharedImpl(private val context: Context) : StorageListResult {
    private val sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    override fun save(modelParameterForSave: ModelParameterForSave, keyName: String) {
        //convert list to json
        val gson = Gson()
        val json = gson.toJson(modelParameterForSave)
        // save json in shared
        sharedPreferences.edit().apply {
            putString(keyName, json)
            apply()
        }
    }

    override fun get(keyName: String): ModelParameterForSave? {
        val json = sharedPreferences.getString(keyName, null) ?: return null
        val gson = Gson()
        val type = object : TypeToken<ModelParameterForSave>() {}.type
        return gson.fromJson(json, type)
    }

    companion object {
        private const val SHARED_NAME = "name"
    }
}