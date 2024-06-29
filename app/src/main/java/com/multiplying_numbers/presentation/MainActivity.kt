package com.multiplying_numbers.presentation

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.multiplying_numbers.R
import com.multiplying_numbers.data.repository.RepositoryListQuestionsImpl
import com.multiplying_numbers.data.storage.GetListStorageImpl
import com.multiplying_numbers.databinding.ActivityMainBinding
import com.multiplying_numbers.domain.usecase.GetListForDropDownMenuUseCase
import com.multiplying_numbers.domain.usecase.GetListQuestionsUseCase

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val getListForDropDownMenuUseCase by lazy {
        GetListForDropDownMenuUseCase()
    }

    private val storage
            by lazy { GetListStorageImpl() }

    private val repository
            by lazy { RepositoryListQuestionsImpl(storage = storage) }

    private val getListQuestionsUseCase
            by lazy { GetListQuestionsUseCase(repository = repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.tvAutoComplete.setOnItemClickListener { _, _, position, _ ->
            val item = getListForDropDownMenuUseCase()[position]
            val listQuestions = getListQuestionsUseCase(modelQuestions = item)
            binding.rv.adapter = RecyclerView(listModel = listQuestions)
        }

    }

    override fun onResume() {
        super.onResume()
        val adapter =
            ArrayAdapter(
                this,
                R.layout.drop_down_item,
                getListForDropDownMenuUseCase().map { it.label })
        binding.tvAutoComplete.setAdapter(adapter)
    }
}