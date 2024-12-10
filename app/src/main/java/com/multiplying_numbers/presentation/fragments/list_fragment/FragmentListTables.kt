package com.multiplying_numbers.presentation.fragments.list_fragment

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.PagerSnapHelper
import com.multiplying_numbers.databinding.FragmentListTablesBinding
import com.multiplying_numbers.domain.TypeTable
import com.multiplying_numbers.domain.models.TableParams
import dagger.hilt.android.AndroidEntryPoint

private const val KEY_INDEX = "key index"
private const val TAG = "FragmentListTables"

@AndroidEntryPoint
class FragmentListTables : Fragment() {
    private lateinit var binding: FragmentListTablesBinding
    private var index = 0
    private val listTablesViewModel: ListTablesViewModel by viewModels()
    private val args by navArgs<FragmentListTablesArgs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate: $this")
        super.onCreate(savedInstanceState)
        args.typeTable?.let {
            when (it) {
                TypeTable.MULTIPLE -> listTablesViewModel.getListMultiple()
                TypeTable.DIVISION -> listTablesViewModel.getListDivision()
                TypeTable.ADDITION -> listTablesViewModel.getListAddition()
                TypeTable.SUBTRACTION -> listTablesViewModel.getListSubtraction()
            }
        }
        savedInstanceState?.getInt(KEY_INDEX)?.let { index = it }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_INDEX, index)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListTablesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeListTablesViewModel()
    }

    // onViewCreated ______________________________________________________________________________
    private fun observeListTablesViewModel() {
        listTablesViewModel.listsTables.observe(requireActivity()) { state ->
            when (state) {
                ListTablesViewModel.StateLists.Initial -> {}
                is ListTablesViewModel.StateLists.ListTables -> {
                    binding.recyclerView.apply {
                        adapter = RecyclerViewListsTables(
                            listsTables = state.listsTables,
                            onItemClickListener = { tableParams ->
                                args.typeTable?.apply {
                                    openSingleTableFragment(tableParams = tableParams)
                                }
                            },
                            indexItem = { indexItem ->
                                index = indexItem
                            })
                    }
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
    private fun openSingleTableFragment(tableParams: TableParams) {
        // put args in action

        val actionREFACTOR =
            FragmentListTablesDirections.actionListFragmentToSingleTab(tableParams = tableParams)
        // navigate to fragment
        Navigation.findNavController(binding.root)
            .navigate(actionREFACTOR)
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