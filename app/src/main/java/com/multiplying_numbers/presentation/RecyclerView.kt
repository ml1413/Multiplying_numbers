package com.multiplying_numbers.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.DropDownItemBinding
import com.multiplying_numbers.databinding.ItemForRecyclerBinding
import com.multiplying_numbers.domain.models.ModelQuestions

class RecyclerView(
    private val listModel: List<ModelQuestions>
) : RecyclerView.Adapter<com.multiplying_numbers.presentation.RecyclerView.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_for_recycler, parent, false)
        return MyHolder(view = view)
    }

    override fun getItemCount() = listModel.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.initView(modelQuestions = listModel[position])
    }

    class MyHolder(view: View) : ViewHolder(view) {
        private val binding = ItemForRecyclerBinding.bind(view)
        fun initView(modelQuestions: ModelQuestions) {
            binding.tv.text = modelQuestions.question
        }
    }
}