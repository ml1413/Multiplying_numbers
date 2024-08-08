package com.multiplying_numbers.presentation.fragment.vistory_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.multiplying_numbers.databinding.FragmentVictoryResultBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentVictoryResult : Fragment() {
    private val args by navArgs<FragmentVictoryResultArgs>()
    private lateinit var binding: FragmentVictoryResultBinding
    private val listResultViewModel: ListResultViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        listResultViewModel.initValueInViewModel(index = args.index)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVictoryResultBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeListResultViewModel()
        binding.buttonBack.setOnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        }
    }

    private fun observeListResultViewModel() {
        listResultViewModel.listResult.observe(requireActivity()) { state ->
            when (state) {
                ListResultViewModel.StateListResult.Initial -> {}
                is ListResultViewModel.StateListResult.Result -> {
                    val listResult = state.listResult.reversed()
                    binding.recyclerViewResult.adapter =
                        RecyclerViewVictoryResult(listModelItemVictory = listResult)

                }
            }
        }
    }
}