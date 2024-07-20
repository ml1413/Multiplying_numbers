package com.multiplying_numbers.presentation.fragment.vistory_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.FragmentVictoryResultBinding


class FragmentVictoryResult : Fragment() {
    private val args by navArgs<FragmentVictoryResultArgs>()
    private lateinit var binding: FragmentVictoryResultBinding

    private val listResultViewModel by lazy {
        ViewModelProvider(this, ListResultViewModelFactory(requireContext(), args.index))
            .get(ListResultViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
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
        listResultViewModel.listResult.observe(requireActivity()) { state ->
            when (state) {
                ListResultViewModel.StateListResult.Initial -> {
                    binding.textView.text = getString(R.string.no_answer)
                }
                is ListResultViewModel.StateListResult.Result -> {
                    val listResult = state.listResult.reversed()
                    binding.recyclerViewResult.adapter =
                        RecyclerViewVictoryResult(listModelItemVictory = listResult)

                }
            }
        }
    }
}