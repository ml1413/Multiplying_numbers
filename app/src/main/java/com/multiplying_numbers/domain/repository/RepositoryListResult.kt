package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelParameterForSave

interface RepositoryListResult {
    fun save(modelParameterForSave: ModelParameterForSave, keyName: String)
    fun get(keyName: String): ModelParameterForSave?
}