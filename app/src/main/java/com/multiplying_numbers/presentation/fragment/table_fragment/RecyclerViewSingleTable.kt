package com.multiplying_numbers.presentation.fragment.table_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ItemForTableRvBinding
import com.multiplying_numbers.domain.models.ModelQuestions

class RecyclerViewSingleTable(
    private val listModelQuestions: List<ModelQuestions>
) : RecyclerView.Adapter<RecyclerViewSingleTable.TableHolder>() {
    override fun getItemCount() = listModelQuestions.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableHolder {
        return TableHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_for_table_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TableHolder, position: Int) {
        holder.initView(modelQuestions = listModelQuestions[position])
    }

    //______________________________________________________________________________________________
    class TableHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemForTableRvBinding.bind(view)
        fun initView(modelQuestions: ModelQuestions) {
            binding.tv.text = modelQuestions.questions
        }
    }
}