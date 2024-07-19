package com.multiplying_numbers.presentation.fragment.single_table_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.multiplying_numbers.R
import com.multiplying_numbers.Utils.printString
import com.multiplying_numbers.databinding.FragmentSingleTableBinding
import com.multiplying_numbers.domain.models.ModelItemVictory
import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.presentation.fragment.MyViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.random.Random

//todo recycler horizontsl height to big
private const val KEY_COUNT_WRONG_ANSWER = "key answer"

class FragmentSingleTable : Fragment() {
    private lateinit var binding: FragmentSingleTableBinding
    private val args by navArgs<FragmentSingleTableArgs>()
    private var buttonAnswerLeftValue = -1
    private var buttonAnswerRightValue = -1
    private var questionCoroutineScope: CoroutineScope? = null
    private var wrongAnswerCoroutineScope: CoroutineScope? = null
    private val singleTableViewModel by lazy {
        ViewModelProvider(
            this,
            MyViewModelProvider(MyViewModelProvider.ViewModelsFactory.SingleTableViewModel)
        ).get(SingleTableViewModel::class.java)
    }
    private val singleQuestionViewModel by lazy {
        ViewModelProvider(this).get(SingleQuestionViewModel::class.java)
    }
    private val countWrongAnswerViewModel by lazy {
        ViewModelProvider(this).get(CountWrongAnswerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setTable in view model if view model is empty
        if (singleQuestionViewModel.singleQuestion.value is SingleQuestionViewModel.SingleQuestionState.Initial
        ) {
            singleTableViewModel.setList(args.index)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingleTableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeSingleTableViewModel()
        observeSingleQuestionViewModel()
        observeCountWrongAnswerViewModel()
        binding.cardLeft.setOnClickListener {
            singleQuestionViewModel.checkAnswer(buttonAnswerLeftValue)
        }
        binding.cardRight.setOnClickListener {
            singleQuestionViewModel.checkAnswer(buttonAnswerRightValue)
        }
        binding.buttonResult.setOnClickListener {
            openFragmentVictory(listResultAnswer = listOf())
        }
    }


    //other fun ____________________________________________________________________________________

    private fun addTextOnAnswerButton(modelQuestions: ModelQuestions) {
        val isCorrectAnswer = Random.nextBoolean()
        val correctAnswer = modelQuestions.num * modelQuestions.factor
        val wrongAnswer = correctAnswer + (1..2).random()

        buttonAnswerLeftValue = if (isCorrectAnswer) correctAnswer else wrongAnswer
        binding.tvAnswerLeft.text = buttonAnswerLeftValue.toString()

        buttonAnswerRightValue = if (!isCorrectAnswer) correctAnswer else wrongAnswer
        binding.tvAnswerRight.text = buttonAnswerRightValue.toString()

    }


    private fun setTextInTvQuestion(modelQuestions: ModelQuestions) {
        binding.tvQuestion.apply {
            CoroutineScope(Dispatchers.Main).apply {
                questionCoroutineScope?.cancel()
                questionCoroutineScope = null
                questionCoroutineScope = this
                launch {
                    text = ""
                    modelQuestions.questions.printString(10) { append(it) }
                    questionCoroutineScope?.cancel()
                    questionCoroutineScope = null
                }
            }


        }
    }

    private fun setCountValueInWrongAnswerLabel(countValue: Int) {
        val string = getString(R.string.count_wrong_answer) + " $countValue"

        binding.tvWrongAnswerLabel.apply {
            // change colo wrongAnswerLabel if count  >0___________________________________________
            if (countValue > 0) setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    android.R.color.holo_red_dark
                )
            )
            //_____________________________________________________________________________________
            CoroutineScope(Dispatchers.Main).apply {
                wrongAnswerCoroutineScope?.cancel()
                wrongAnswerCoroutineScope = null
                wrongAnswerCoroutineScope = this
                launch {
                    text = ""
                    string.printString(10) { append(it) }
                    wrongAnswerCoroutineScope?.cancel()
                    wrongAnswerCoroutineScope = null
                }
            }
        }
    }

    private fun openFragmentVictory(listResultAnswer: List<ModelQuestions>) {
        val array = listResultAnswer.toTypedArray()
        val data = System.currentTimeMillis()

        val modelItemVictory = ModelItemVictory(
            keyNameTable = args.index.toString(),
            date = data,
            hasWrongAnswer = array.isNotEmpty(),
            listAnswer = listResultAnswer
        )
        val action =
            FragmentSingleTableDirections
                .actionSingleTabFragmentToFragmentVictoryResult(
                    modelItemResult = modelItemVictory
                )
        Navigation.findNavController(binding.root)
            .navigate(action)
    }

    // observe view model __________________________________________________________________________
    private fun observeSingleQuestionViewModel() {
        singleQuestionViewModel.singleQuestion.observe(requireActivity()) { state ->
            when (state) {
                SingleQuestionViewModel.SingleQuestionState.Initial -> {}
                is SingleQuestionViewModel.SingleQuestionState.Result -> {
                    val modelQuestions = state.modelQuestions
                    setTextInTvQuestion(modelQuestions)
                    addTextOnAnswerButton(modelQuestions)
                }

                is SingleQuestionViewModel.SingleQuestionState.Answer -> {
                    val modelQuestions = state.modelQuestions
                    singleQuestionViewModel.setInitial()
                    singleTableViewModel.setAnswerInTableList(modelQuestions = modelQuestions)
                }

                SingleQuestionViewModel.SingleQuestionState.Victory -> {
                    countWrongAnswerViewModel.showResultAnswer()
                }
            }
        }
    }

    private fun observeSingleTableViewModel() {
        singleTableViewModel.singleList.observe(requireActivity()) { state ->
            when (state) {
                SingleTableViewModel.SingleTabState.Initial -> {}
                SingleTableViewModel.SingleTabState.Loading -> {}
                is SingleTableViewModel.SingleTabState.SingleStateResult -> {
                    val listTable = state.list
                    countWrongAnswerViewModel.setCountWrongAnswer(listTable = listTable)
                    binding.recyclerViewTable.adapter =
                        RecyclerViewSingleTable(listModelQuestions = listTable)
                    singleQuestionViewModel.setSingleQuestion(listModels = listTable)
                }

                is SingleTableViewModel.SingleTabState.AnswerResult -> {
                    val listResultAnswer = state.list
                    openFragmentVictory(listResultAnswer = listResultAnswer)
                }
            }
        }
    }


    private fun observeCountWrongAnswerViewModel() {
        countWrongAnswerViewModel.countWrongAnswer.observe(requireActivity()) { state ->
            when (state) {
                CountWrongAnswerViewModel.StateWrongAnswer.Initial -> {
                }

                is CountWrongAnswerViewModel.StateWrongAnswer.WrongAnswerResult -> {
                    val countWrongAnswer = state.listResultAnswer.sumOf { it.countWrongAnswer }
                    setCountValueInWrongAnswerLabel(countValue = countWrongAnswer)
                }

                is CountWrongAnswerViewModel.StateWrongAnswer.ResultVictory -> {
                    singleTableViewModel.showResult()

                }
            }
        }
    }
}