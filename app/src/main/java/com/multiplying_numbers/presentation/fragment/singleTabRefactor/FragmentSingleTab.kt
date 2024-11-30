package com.multiplying_numbers.presentation.fragment.singleTabRefactor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.multiplying_numbers.R
import com.multiplying_numbers.Utils.printString
import com.multiplying_numbers.databinding.FragmentSingleTabBinding
import com.multiplying_numbers.domain.models.ColorCountWrongAnswer
import com.multiplying_numbers.domain.models.ModelItemTab
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

private const val TAG = "FragmentSingleTabRAFECTOR"
// todo Add history button if history exists
@AndroidEntryPoint
class FragmentSingleTab : Fragment() {
    private lateinit var binding: FragmentSingleTabBinding
    private val singleTabViewModel: SingleTabViewModel by viewModels()
    private val args by navArgs<FragmentSingleTabArgs>()
    private var scopeForWrongAnswer: CoroutineScope? = null
    private var scopeForQuestions: CoroutineScope? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        singleTabViewModel.getTable(idTable = args.idTable)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingleTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickOnLeftButton()
        clickOnRightButton()
        clickOnBackButton()
        observeViewModel()
    }


    /**___OTHER FUN______________________________________________________________________________*/

    private fun observeViewModel() {
        singleTabViewModel.table.observe(requireActivity()) { state ->
            when (state) {
                SingleTabViewModel.StateTable.Initial -> {}
                is SingleTabViewModel.StateTable.ResumeGame -> {
                    val modelSingleTabREFACTOR = state.modelItemTab
                    setModelInRecyclerViewAdapter(modelItemTab = modelSingleTabREFACTOR)
                    setTextOnQuestions(modelItemTab = modelSingleTabREFACTOR)
                    tesTextOnLeftAndRightButton(modelItemTab = modelSingleTabREFACTOR)
                    setTextOnLabelWrongAnswer(modelItemTab = modelSingleTabREFACTOR)

                }

                is SingleTabViewModel.StateTable.Victory -> {
                    val idTable = state.modelItemTab.idTable

                    singleTabViewModel.saveInStorage()

                    val action = FragmentSingleTabDirections
                        .actionSingleTabToFragmentHistory(idTable = idTable)
                    Navigation.findNavController(binding.root).navigate(action)

                }

                SingleTabViewModel.StateTable.DisableButton -> {
                    binding.cardLeft.isVisible = false
                    binding.cardRight.isVisible = false
                }
            }
        }
    }

    private fun clickOnRightButton() {
        binding.cardRight.setOnClickListener {
            singleTabViewModel.checkRightAnswer()
        }
    }

    private fun clickOnLeftButton() {
        binding.cardLeft.setOnClickListener {
            singleTabViewModel.checkLeftAnswer()
        }
    }


    private fun setTextOnLabelWrongAnswer(modelItemTab: ModelItemTab) {
        if (modelItemTab.isPrintCountWrongAnswer) {
            val count = modelItemTab.countWrongAnswer
            val label = getString(R.string.count_wrong_answer).replace("0", count.toString())
            binding.tvWrongAnswerLabel.apply {
                // set color
                setTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        when (modelItemTab.colorCountWrongAnswer) {
                            ColorCountWrongAnswer.COLOR_DEFAULT -> android.R.color.black
                            ColorCountWrongAnswer.COLOR_WRONG -> android.R.color.holo_red_dark
                            ColorCountWrongAnswer.COLOR_CORRECT -> android.R.color.holo_green_dark
                        }
                    )
                )

                //print label
                CoroutineScope(Dispatchers.Main).apply {
                    scopeForWrongAnswer?.cancel();scopeForWrongAnswer = null;scopeForWrongAnswer =
                    this
                    launch {
                        text = ""
                        label.printString(10, stringForPrint = { append(it) })
                        scopeForWrongAnswer?.cancel();scopeForWrongAnswer = null
                    }
                }
            }
        }

    }

    private fun tesTextOnLeftAndRightButton(modelItemTab: ModelItemTab) {
        binding.tvAnswerLeft.text =
            modelItemTab.textForLeftButton.toString()
        binding.tvAnswerRight.text =
            modelItemTab.textForRightButton.toString()
    }

    private fun setTextOnQuestions(modelItemTab: ModelItemTab) {
        binding.tvQuestion.apply {
            CoroutineScope(Dispatchers.Main).apply {
                scopeForQuestions?.cancel();scopeForQuestions = null;scopeForQuestions = this
                launch {
                    text = ""
                    modelItemTab.questionString.printString(
                        10,
                        stringForPrint = { append(it) })
                    scopeForQuestions?.cancel();scopeForQuestions = null
                }
            }
        }
    }

    private fun setModelInRecyclerViewAdapter(modelItemTab: ModelItemTab) {
        binding.recyclerViewTable.adapter =
            RecyclerViewSingleTab(modelItemTab = modelItemTab)
    }

    private fun clickOnBackButton() {
        binding.buttonBack.setOnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        }
    }

}