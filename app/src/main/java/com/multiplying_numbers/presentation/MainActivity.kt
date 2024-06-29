package com.multiplying_numbers.presentation

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ActivityMainBinding
import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.usecase.GetListForDropDownMenuUseCase

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val getListForDropDownMenuUseCase by lazy {
        GetListForDropDownMenuUseCase()
    }
    private val viewModelListItem by lazy {
        ViewModelProvider(this, ViewModelQuestionsFactory()).get(ViewModelQuestions::class.java)
    }
    private val viewModelItem by lazy {
        ViewModelProvider(this).get(RandomItemForQuestionsScreenViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModelListItem.listQuestions.observe(this) { state ->
            when (state) {
                ViewModelQuestions.StateQuestions.Initial -> {}
                ViewModelQuestions.StateQuestions.Loading -> {}
                is ViewModelQuestions.StateQuestions.Result -> {
                    val listModelQuestions = state.list

                    addListInAdapterRecyclerView(list = listModelQuestions)

                    viewModelItem.setItem(listItem = listModelQuestions)
                }
            }
        }
        viewModelItem.item.observe(this) { state ->
            when (state) {
                RandomItemForQuestionsScreenViewModel.StateItem.Initial -> {}
                RandomItemForQuestionsScreenViewModel.StateItem.Loading -> {}
                is RandomItemForQuestionsScreenViewModel.StateItem.ResultItem -> {
                    val item = state.item
                    binding.tvQuestions.text = item.questionSingle
                }
            }
        }

        binding.tvAutoComplete.setOnItemClickListener { _, _, position, _ ->
            viewModelItem.setInitial()
            val item = getListForDropDownMenuUseCase()[position]
            viewModelListItem.getList(modelQuestions = item)
        }

    }

    private fun addListInAdapterRecyclerView(list: List<ModelQuestions>) {
        binding.rv.adapter = RecyclerView(listModel = list)
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