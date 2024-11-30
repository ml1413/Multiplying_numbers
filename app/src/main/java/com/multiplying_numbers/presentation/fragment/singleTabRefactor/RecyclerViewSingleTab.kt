package com.multiplying_numbers.presentation.fragment.singleTabRefactor

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ItemForTableRvBinding
import com.multiplying_numbers.domain.models.ColorItem
import com.multiplying_numbers.domain.models.ModelItemTab
import com.multiplying_numbers.domain.models.ModelQuestions

class RecyclerViewSingleTab(
    private val modelItemTab: ModelItemTab
) : RecyclerView.Adapter<RecyclerViewSingleTab.TableHolderREFACTOR>() {

    class TableHolderREFACTOR(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemForTableRvBinding.bind(view)
        fun initView(modelSingleTabREFACTOR: ModelQuestions) {
            binding.tv.apply {
                text = modelSingleTabREFACTOR.questionsString
                setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        when (modelSingleTabREFACTOR.colorItem) {
                            ColorItem.COLOR_DEFAULT -> android.R.color.black
                            ColorItem.COLOR_WRONG -> android.R.color.holo_red_dark
                            ColorItem.COLOR_CORRECT -> android.R.color.holo_green_dark
                        }
                    )
                )
                if (modelSingleTabREFACTOR.isAnimated) {
                    ObjectAnimator.ofFloat(itemView, View.ALPHA, 0f, 1f)
                        .apply {
                            duration = 1500
                            start()
                        }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableHolderREFACTOR {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_for_table_rv, parent, false)
        return TableHolderREFACTOR(view = view)
    }

    override fun getItemCount() = modelItemTab.listModelQuestions.size

    override fun onBindViewHolder(holder: TableHolderREFACTOR, position: Int) {
        val modelSingleTabREFACTOR = modelItemTab.listModelQuestions[position]
        holder.initView(modelSingleTabREFACTOR = modelSingleTabREFACTOR)
    }
}