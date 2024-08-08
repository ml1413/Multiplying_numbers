package com.multiplying_numbers.presentation.fragment.list_fragment

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.PagerSnapHelper
import com.multiplying_numbers.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

private const val KEY_INDEX = "key index"

@AndroidEntryPoint
class FragmentList : Fragment() {
    private lateinit var binding: FragmentListBinding
    private var adapter: RecyclerViewListsTables? = null
    private var index = 0
    private val listTablesViewModel: ListTablesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.getInt(KEY_INDEX)?.let { index = it }
        listTablesViewModel.getData()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_INDEX, index)
        super.onSaveInstanceState(outState)
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
        observeListTablesViewModel()
        binding.buttonBack.setOnClickListener {
            requireActivity().finish()
        }

    }

    // observe view model ______________________________________________________________________________
    private fun observeListTablesViewModel() {
        listTablesViewModel.listsTables.observe(requireActivity()) { state ->
            when (state) {
                ListTablesViewModel.StateLists.Initial -> {}
                is ListTablesViewModel.StateLists.Result -> {
                    adapter = RecyclerViewListsTables(
                        listsTables = state.listsTables,
                        onItemClickListener = { indexOf ->
                            index = indexOf
                            openSingleTableFragment(indexOf)
                        })
                    adapter?.let { binding.recyclerView.adapter = it }
                    PagerSnapHelper().apply { attachToRecyclerView(binding.recyclerView) }

                    setPaddingOnItemRecyclerview { padding ->
                        binding.recyclerView.setPadding(padding, 0, padding, 0)
                        binding.recyclerView.smoothScrollToPosition(index)
                    }
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

    private fun setPaddingOnItemRecyclerview(padding: (Int) -> Unit) {

        binding.recyclerView.viewTreeObserver.addOnGlobalLayoutListener(
            object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {

                    binding.recyclerView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    // get width display
                    val display = DisplayMetrics()
                    val displayManager =
                        requireContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
                    displayManager.defaultDisplay.getMetrics(display)
                    val displayWidth = display.widthPixels
                    // width item
                    val rootViewWidth = binding.recyclerView.getChildAt(0).width
                    val padding = displayWidth / 2 - rootViewWidth / 2
                    padding(padding)
                }

            }
        )
    }

}