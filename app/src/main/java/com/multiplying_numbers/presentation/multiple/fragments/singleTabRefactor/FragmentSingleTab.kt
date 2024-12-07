package com.multiplying_numbers.presentation.multiple.fragments.singleTabRefactor

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.multiplying_numbers.R
import com.multiplying_numbers.Utils.printString
import com.multiplying_numbers.databinding.FragmentSingleTabBinding
import com.multiplying_numbers.domain.multiple.models.ColorCountWrongAnswer
import com.multiplying_numbers.domain.multiple.models.ModelSingleTab
import com.multiplying_numbers.domain.multiple.usecase.CheckHistoryUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "FragmentSingleTabRAFECTOR"

@AndroidEntryPoint
class FragmentSingleTab @Inject constructor() : Fragment() {
    @Inject
    lateinit var checkHistoryUseCase: CheckHistoryUseCase


    private lateinit var binding: FragmentSingleTabBinding
    private val singleTabViewModel: SingleTabViewModel by viewModels()
    private val args by navArgs<FragmentSingleTabArgs>()

    //print scope for questions
    private var scopeForQuestions: CoroutineScope? = null

    // title wrong answer and print scope
    private var scopeWrongAnswer: CoroutineScope? = null
    private val spannableString by lazy { SpannableStringBuilder("") }

    //history
    private var isHistoryExist: Boolean = false
    private var idTable = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args.tableParams?.let { tableParams ->
            singleTabViewModel.getTable(tableParams = tableParams)
            idTable = tableParams.idTable
        }
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
        observeViewModel()
        initialButtonHistory()
    }


    /**___OTHER FUN______________________________________________________________________________*/
    //onViewCreated
    private fun initialButtonHistory() {
        //todo set padding button menu
        requireActivity().addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    if (isHistoryExist)
                        menuInflater.inflate(R.menu.menu_histiry, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return when (menuItem.itemId) {
                        R.id.item_history -> {
                            openFragmentHistory(idTable = idTable)
                            true
                        }

                        else -> false
                    }
                }
            },
            viewLifecycleOwner,
            Lifecycle.State.RESUMED
        )
    }

    //onViewCreated
    private fun observeViewModel() {
        singleTabViewModel.table.observe(requireActivity()) { state ->
            when (state) {
                SingleTabViewModel.StateTable.Initial -> {}
                is SingleTabViewModel.StateTable.ResumeGame -> {
                    val modelSingleTab = state.modelSingleTab
                    checkHistory(modelSingleTab = modelSingleTab)
                    setModelInRecyclerViewAdapter(modelSingleTab = modelSingleTab)
                    setTextOnQuestions(modelSingleTab = modelSingleTab)
                    tesTextOnLeftAndRightButton(modelSingleTab = modelSingleTab)
                    setTextOnLabelWrongAnswer(modelSingleTab = modelSingleTab)

                }

                is SingleTabViewModel.StateTable.Victory -> {
                    singleTabViewModel.saveInStorage()
                    val idTable = state.modelSingleTab.idTable
                    openFragmentHistory(idTable)
                }

                SingleTabViewModel.StateTable.DisableButton -> {
                    binding.cardLeft.isInvisible = true
                    binding.cardRight.isInvisible = true
                }
            }
        }
    }

    //observeViewModel
    private fun checkHistory(modelSingleTab: ModelSingleTab) {
        idTable = modelSingleTab.idTable
        isHistoryExist = checkHistoryUseCase(idTable = idTable)
    }

    //observeViewModel
    private fun openFragmentHistory(idTable: Int) {
        val action = FragmentSingleTabDirections
            .actionSingleTabToFragmentHistory(idTable = idTable)
        Navigation.findNavController(binding.root).navigate(action)
    }

    //onViewCreated
    private fun clickOnRightButton() {
        binding.cardRight.setOnClickListener {
            singleTabViewModel.checkRightAnswer()
        }
    }

    //onViewCreated
    private fun clickOnLeftButton() {
        binding.cardLeft.setOnClickListener {
            singleTabViewModel.checkLeftAnswer()
        }
    }

    //observeViewModel
    private fun setTextOnLabelWrongAnswer(modelSingleTab: ModelSingleTab) {
        if (modelSingleTab.isPrintCountWrongAnswer) {
            val count = modelSingleTab.countWrongAnswer
            val label = getString(R.string.count_wrong_answer).replace("0", count.toString())
            val appBar = (requireActivity() as AppCompatActivity).supportActionBar
            appBar?.apply {

                //print label
                CoroutineScope(Dispatchers.Main).apply {
                    restartWrongAnswerCoroutine()
                    val color = getColorForTitle(modelSingleTab = modelSingleTab)
                    launch {
                        spannableString.apply {
                            // todo need fix bag
                            clear()
                            title = this
                            label.printString(10,
                                stringForPrint = {
                                    append(it)
                                    setSpan(
                                        ForegroundColorSpan(color),
                                        0,
                                        length,
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                    )
                                    title = this

                                })
                        }
                        closeWrongAnswerCoroutine()
                    }
                }
            }
        }

    }

    //setTextOnLabelWrongAnswer
    private fun getColorForTitle(modelSingleTab: ModelSingleTab): Int {
        val color = ContextCompat.getColor(
            requireActivity(),
            when (modelSingleTab.colorCountWrongAnswer) {
                ColorCountWrongAnswer.COLOR_DEFAULT -> android.R.color.black
                ColorCountWrongAnswer.COLOR_WRONG -> android.R.color.holo_red_dark
                ColorCountWrongAnswer.COLOR_CORRECT -> android.R.color.holo_green_dark
            }
        )
        return color
    }

    //setTextOnLabelWrongAnswer
    private fun CoroutineScope.restartWrongAnswerCoroutine() {
        closeWrongAnswerCoroutine();scopeWrongAnswer = this
    }

    //setTextOnLabelWrongAnswer
    private fun closeWrongAnswerCoroutine() {
        scopeWrongAnswer?.cancel();scopeWrongAnswer = null
    }

    //observeViewModel
    private fun tesTextOnLeftAndRightButton(modelSingleTab: ModelSingleTab) {
        binding.tvAnswerLeft.text =
            modelSingleTab.textForLeftButton.toString()
        binding.tvAnswerRight.text =
            modelSingleTab.textForRightButton.toString()
    }

    //observeViewModel
    private fun setTextOnQuestions(modelSingleTab: ModelSingleTab) {
        binding.tvQuestion.apply {
            text = ""
            CoroutineScope(Dispatchers.Main).apply {
                resetQuestionCoroutine()
                launch {
                    modelSingleTab.questionString.printString(
                        10,
                        stringForPrint = { append(it) })
                    cancelQuestionCoroutine()
                }
            }
        }
    }

    //setTextOnQuestions
    private fun CoroutineScope.resetQuestionCoroutine() {
        cancelQuestionCoroutine();scopeForQuestions = this
    }

    //setTextOnQuestions
    private fun cancelQuestionCoroutine() {
        scopeForQuestions?.cancel();scopeForQuestions = null
    }

    //observeViewModel
    private fun setModelInRecyclerViewAdapter(modelSingleTab: ModelSingleTab) {
        binding.recyclerViewSingleTab.apply {
            adapter = RecyclerViewSingleTab(modelSingleTab = modelSingleTab)
        }

    }


}