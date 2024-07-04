package com.multiplying_numbers.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.multiplying_numbers.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val listTablesViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            ListTablesVMFactory()
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
                            onItemClickListener = {
                                Log.d("TAG1", "onViewCreated:  $it")
                            })
                }
            }
        }
    }

}