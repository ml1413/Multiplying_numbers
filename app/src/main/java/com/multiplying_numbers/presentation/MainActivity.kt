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
    private var listModelQuestions: List<ModelQuestions>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observViewModelList()
        observViewModelItem()

        dropDownMenuListener()
        fabYesListener()
        fabNoListenr()

    }

    private fun fabNoListenr() {
        binding.fabNo.setOnClickListener {
            viewModelItem.checkAnswerNo()
            addItemInViewModelRandomItem(listModelQuestions)
        }
    }

    private fun fabYesListener() {
        binding.fabYes.setOnClickListener {
            viewModelItem.checkAnswerYes()
            addItemInViewModelRandomItem(listModelQuestions)
        }
    }

    private fun dropDownMenuListener() {
        binding.tvAutoComplete.setOnItemClickListener { _, _, position, _ ->
            viewModelItem.setInitial()
            val item = getListForDropDownMenuUseCase()[position]
            viewModelListItem.getList(modelQuestions = item)
        }
    }

    private fun observViewModelItem() {
        viewModelItem.item.observe(this) { state ->
            when (state) {
                RandomItemForQuestionsScreenViewModel.StateItem.Initial -> {}
                RandomItemForQuestionsScreenViewModel.StateItem.Loading -> {}
                is RandomItemForQuestionsScreenViewModel.StateItem.ResultItem -> {
                    val item = state.item
                    binding.tvQuestions.text = item.questionSingle
                }

                is RandomItemForQuestionsScreenViewModel.StateItem.Answer -> {
                    val itemAnswer = state.item
                    viewModelListItem.setAnswerItemIlist(item = itemAnswer)
                    viewModelItem.setInitial()
                }

                RandomItemForQuestionsScreenViewModel.StateItem.Completed -> {
                    binding.tvQuestions.text = getString(R.string.text_is_table_bottom)
                }
            }
        }
    }

    private fun observViewModelList() {
        viewModelListItem.listQuestions.observe(this) { state ->
            when (state) {
                ViewModelQuestions.StateQuestions.Initial -> {}
                ViewModelQuestions.StateQuestions.Loading -> {}
                is ViewModelQuestions.StateQuestions.Result -> {
                    listModelQuestions = state.list

                    addListInAdapterRecyclerView(list = listModelQuestions)

                    addItemInViewModelRandomItem(listModelQuestions)
                }
            }
        }
    }

    private fun addItemInViewModelRandomItem(listModelQuestions: List<ModelQuestions>?) {
        listModelQuestions?.let {
            viewModelItem.setItem(listItem = it)
        }
    }

    private fun addListInAdapterRecyclerView(list: List<ModelQuestions>?) {
        list?.let {
            binding.rv.adapter = RecyclerView(listModel = it)
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