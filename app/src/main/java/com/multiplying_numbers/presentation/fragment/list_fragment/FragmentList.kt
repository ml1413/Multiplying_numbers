package com.multiplying_numbers.presentation.fragment.list_fragment

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.PagerSnapHelper
import com.multiplying_numbers.databinding.FragmentListBinding
import com.multiplying_numbers.presentation.fragment.MyViewModelProvider


class FragmentList : Fragment() {
    private lateinit var binding: FragmentListBinding
    private var adapter: RecyclerViewListsTables? = null
    private val listTablesViewModel by lazy {
        ViewModelProvider(
            this,
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
                    adapter = RecyclerViewListsTables(
                        listsTables = state.listsTables,
                        onItemClickListener = { indexOf ->
                            openSingleTableFragment(indexOf)
                        })
                    adapter?.let { binding.recyclerView.adapter = it }
                    PagerSnapHelper().apply { attachToRecyclerView(binding.recyclerView) }

                    /***/
                    // get width display
                    val displayWidth = DisplayMetrics()
                    val displayManager =
                        requireContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
                    displayManager.defaultDisplay.getMetrics(displayWidth)
                    val widget = displayWidth.widthPixels / 2
                    // width item
                    //todo need get view width
                    /***/
                }
            }
        }
    }

    /** other fun ____________________________________________________________________________________*/
    private fun openSingleTableFragment(indexOf: Int) {
        // put args in action
        val action =
            FragmentListDirections.actionListFragmentToTableFragment(indexOf)
        // navigate to fragment
        Navigation.findNavController(binding.root)
            .navigate(action)
    }

}