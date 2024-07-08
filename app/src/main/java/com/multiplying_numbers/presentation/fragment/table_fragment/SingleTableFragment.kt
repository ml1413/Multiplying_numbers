package com.multiplying_numbers.presentation.fragment.table_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.multiplying_numbers.databinding.FragmentSingleTableBinding
import com.multiplying_numbers.presentation.fragment.MyViewModelProvider


class SingleTableFragment : Fragment() {
    private lateinit var binding: FragmentSingleTableBinding
    val args by navArgs<SingleTableFragmentArgs>()
    private val singleTableViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            MyViewModelProvider(MyViewModelProvider.ViewModelsFactory.SingleTableViewModel)
        ).get(SingleTableViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        singleTableViewModel.setList(args.index)

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
        singleTableViewModel.singleList.observe(requireActivity()) { state ->
            when (state) {
                SingleTableViewModel.SingleTabState.Initial -> {}
                SingleTableViewModel.SingleTabState.Loading -> {}
                is SingleTableViewModel.SingleTabState.SingleStateResult -> {
                    binding.recyclerViewTable.adapter = RecyclerViewSingleTable(state.list)
                }
            }
        }
    }


}