package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelWrapper

interface RepositoryListResult {
    fun saveList(listResult :List<ModelWrapper>, keyName:String)
    fun getList(keyName: String):List<ModelWrapper>?
}