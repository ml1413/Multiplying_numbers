package com.multiplying_numbers.presentation.fragment.vistory_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.multiplying_numbers.databinding.FragmentVictoryResultBinding
import com.multiplying_numbers.domain.models.ModelWrapper


class FragmentVictoryResult : Fragment() {
    private val args by navArgs<FragmentVictoryResultArgs>()
    private lateinit var binding: FragmentVictoryResultBinding

    private val listResultViewModel by lazy {
        ViewModelProvider(this, ListResultViewModelFactory(requireContext()))
            .get(ListResultViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listLabelAndResult = mutableListOf<ModelWrapper>()
        val modelLabel = args.modelLAbelAnswer
        val listResult = args.listResultAnswer
        if (modelLabel != null && listResult != null) {
            listLabelAndResult.add(ModelWrapper.ModelLabel(modelLabelResultAnswer = modelLabel))
            listResult.forEach { modelQuestions ->
                listLabelAndResult.add(ModelWrapper.ModelQuestion(modelQuestions = modelQuestions))
            }

            listResultViewModel.setResult(
                listResult = listLabelAndResult,
                keyName = modelLabel.keyNameTable
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVictoryResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        args.modelLAbelAnswer?.keyNameTable?.let {
            listResultViewModel.saveListInStorage(keyName = it)
        }
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listResultViewModel.listResult.observe(requireActivity()) { state ->
            when (state) {
                ListResultViewModel.StateListResult.Initial -> {}
                is ListResultViewModel.StateListResult.Result -> {
                    val listResult = state.listResult

                    binding.recyclerViewResult.adapter =
                        RecyclerViewVictoryResult(listLabelAndModelAnswer = listResult)


                }
            }
        }
    }
}