package com.multiplying_numbers.presentation.multiple.fragment.history_fragment_

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.multiplying_numbers.databinding.FragmentHistoryBinding
import com.multiplying_numbers.domain.multiple.models.ModelHistory
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "FragmentHistoryREFACTOR"
// todo need color answer on recycler view
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
        clickOnBackButton()
        observeViewModel()
    }

    private fun observeViewModel() {
        historyViewModel.history.observe(requireActivity()) { state ->
            when (state) {
                HistoryViewModel.StateHistory.Initial -> {}
                is HistoryViewModel.StateHistory.HistoryAnswer -> {
                    val modelHistoryREFACTOR = state.modelHistory
                    initRecyclerView(modelHistoryREFACTOR)
                }
            }
        }
    }

    private fun clickOnBackButton() {
        binding.buttonBack.setOnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        }
    }

    private fun initRecyclerView(modelHistoryREFACTOR: ModelHistory) {
        val adapter =
            HistoryRecyclerView(modelHistory = modelHistoryREFACTOR)
        binding.recyclerViewResult.adapter = adapter
    }

}