package com.multiplying_numbers.presentation.multiple.fragments.list_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ItemForRvGridBinding
import com.multiplying_numbers.domain.multiple.models.ModelTabForCard

class RecyclerViewListsTables(
    private val listsTables: List<ModelTabForCard>,
    val onItemClickListener: (Int) -> Unit = {},
    val indexItem: (Int) -> Unit = {}
) : RecyclerView.Adapter<RecyclerViewListsTables.MyTableHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTableHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_for_rv_grid, parent, false)
        return MyTableHolder(view = view)
    }

    override fun getItemCount() = listsTables.size

    override fun onBindViewHolder(holder: MyTableHolder, position: Int) {

        holder.initView(
            modelTab = listsTables[position],
            onItemClickListener = { idTable ->
                onItemClickListener(idTable)
                indexItem(position)
            })
    }

    class MyTableHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemForRvGridBinding.bind(view)
        fun initView(
            modelTab: ModelTabForCard,
            onItemClickListener: (Int) -> Unit = {}
        ) {
            var messageInTable = ""
            modelTab.listQuestions.forEach { messageInTable += it + "\n" }

            val label = "-- ${modelTab.idTable} --"

            binding.tv.text = messageInTable
            binding.labeled.text = label
            binding.cardView.setOnClickListener {
                onItemClickListener(modelTab.idTable)
            }

        }
    }
}