package com.multiplying_numbers.presentation.fragment.list_fragment

import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ItemForRvGridBinding
import com.multiplying_numbers.domain.models.ModelQuestions

class RecyclerViewListsTables(
    private val listsTables: List<List<ModelQuestions>>,
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

    class MyTableHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemForRvGridBinding.bind(view)
        fun initView(
            listModels: List<ModelQuestions>,
            onItemClickListener: (List<ModelQuestions>) -> Unit = {}
        ) {
            var messageInTable = ""
            listModels.forEach { messageInTable += it.questions + "\n" }

            val label = "-- ${listModels[0].factor} --"

            binding.tv.text = messageInTable
            binding.labeled.text = label
            binding.cardView.setOnClickListener {
                onItemClickListener(listModels)
            }

        }
    }
}