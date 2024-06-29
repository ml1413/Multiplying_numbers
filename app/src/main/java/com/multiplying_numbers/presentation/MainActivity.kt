package com.multiplying_numbers.presentation

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ActivityMainBinding
import com.multiplying_numbers.domain.usecase.GetListForDropDownMenuUseCase

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val getListForDropDownMenuUseCase by lazy {
        GetListForDropDownMenuUseCase()
    }
    private val viewModel by lazy {
        ViewModelProvider(this, ViewModelQuestionsFactory()).get(ViewModelQuestions::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.listQuestions.observe(this) { state ->
            when (state) {
                ViewModelQuestions.StateQuestions.Initial -> {}
                ViewModelQuestions.StateQuestions.Loading -> {}
                is ViewModelQuestions.StateQuestions.Result -> {
                    val list = state.list
                    binding.rv.adapter = RecyclerView(listModel = list)
                }
            }
        }

        binding.tvAutoComplete.setOnItemClickListener { _, _, position, _ ->
            val item = getListForDropDownMenuUseCase()[position]
            viewModel.getList(modelQuestions = item)
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