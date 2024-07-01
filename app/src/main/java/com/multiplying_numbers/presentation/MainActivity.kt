package com.multiplying_numbers.presentation

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ActivityMainBinding
import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.usecase.GetListForDropDownMenuUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

        observeViewModelList()
        observViewModelItem()

        dropDownMenuListener()
        fabYesListener()
        fabNoListener()

    }

    private fun fabNoListener() {
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

                    setColorAnswer(itemAnswer)
                }

                RandomItemForQuestionsScreenViewModel.StateItem.Completed -> {
                    binding.tvQuestions.text = getString(R.string.text_is_table_bottom)
                    binding.tvAutoComplete.setText(getString(R.string.choice_table))
                }
            }
        }
    }

    private fun setColorAnswer(itemAnswer: ModelQuestions) {
        val color = if (itemAnswer.isCorrect == true) {
            android.R.color.holo_green_dark

        } else {
            android.R.color.holo_red_dark
        }
        setColorTemporarilyInBottomContainer(color)
    }

    private fun setColorTemporarilyInBottomContainer(color: Int) {
        lifecycleScope.launch {
            binding.cardViewExample.setBackgroundColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    color
                )
            )
            delay(400)
            binding.cardViewExample.setBackgroundColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    android.R.color.transparent
                )
            )
        }
    }

    private fun observeViewModelList() {
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