package com.multiplying_numbers.presentation.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ItemForRvGridBinding
import com.multiplying_numbers.domain.models.ModelQuestions2

class RecyclerViewListsTables(
    private val listsTables: List<List<ModelQuestions2>>,
    val onItemClickListener: (Int) -> Unit = {}
) : RecyclerView.Adapter<RecyclerViewListsTables.MyTableHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTableHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_for_rv_grid, parent, false)
        return MyTableHolder(view = view)
    }

    override fun getItemCount() = listsTables.size

    override fun onBindViewHolder(holder: MyTableHolder, position: Int) {
        holder.initView(
            listModels = listsTables[position],
            onItemClickListener = { listModels ->
                onItemClickListener(listsTables.indexOf(listModels))
            })
    }

    class MyTableHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemForRvGridBinding.bind(view)
        fun initView(
            listModels: List<ModelQuestions2>,
            onItemClickListener: (List<ModelQuestions2>) -> Unit = {}
        ) {

            val messageInTable = listModels[listModels[0].id - 1].questions
            val label = "-- ${listModels[0].id} --"

            binding.tv.text = messageInTable
            binding.labeled.text = label
            itemView.setOnClickListener {
                onItemClickListener(listModels)
            }
        }
    }
}