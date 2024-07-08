package com.multiplying_numbers.presentation.fragment.list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.multiplying_numbers.databinding.FragmentListBinding
import com.multiplying_numbers.presentation.fragment.MyViewModelProvider


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val listTablesViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            MyViewModelProvider(MyViewModelProvider.ViewModelsFactory.ListTablesViewModel)
        ).get(ListTablesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listTablesViewModel.getData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listTablesViewModel.listsTables.observe(requireActivity()) { state ->
            when (state) {
                ListTablesViewModel.StateLists.Initial -> {}
                is ListTablesViewModel.StateLists.Result -> {
                    binding.recyclerView.adapter =
                        RecyclerViewListsTables(
                            listsTables = state.listsTables,
                            onItemClickListener = { indexOf ->
                                // put args in action
                                val action =
                                    ListFragmentDirections.actionListFragmentToTableFragment(indexOf)
                                // navigate to fragment
                                Navigation.findNavController(binding.root)
                                    .navigate(action)
                            })
                }
            }
        }
    }

}