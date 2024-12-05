package com.multiplying_numbers.presentation.multiple.fragments.history_fragment_

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.multiplying_numbers.databinding.FragmentHistoryBinding
import com.multiplying_numbers.domain.multiple.models.ModelHistory
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "FragmentHistoryREFACTOR"

@AndroidEntryPoint
class FragmentHistory : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private val args by navArgs<FragmentHistoryArgs>()
    private val historyViewModel by viewModels<HistoryViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idTable = args.idTable
        historyViewModel.getHistoryFromStorage(idTable = idTable)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        historyViewModel.history.observe(requireActivity()) { state ->
            when (state) {
                HistoryViewModel.StateHistory.Initial -> {}
                is HistoryViewModel.StateHistory.HistoryAnswer -> {
                    val modelHistory = state.modelHistory
                    initRecyclerView(modelHistory)
                }
            }
        }
    }


    private fun initRecyclerView(modelHistoryStorage: ModelHistory) {
        binding.recyclerViewResult.apply {
            adapter = HistoryRecyclerView(modelHistory = modelHistoryStorage)
        }
    }

}