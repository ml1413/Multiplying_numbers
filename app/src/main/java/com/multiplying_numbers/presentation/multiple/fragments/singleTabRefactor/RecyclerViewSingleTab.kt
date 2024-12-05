package com.multiplying_numbers.presentation.multiple.fragments.singleTabRefactor

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ItemTextViewRvBinding
import com.multiplying_numbers.domain.multiple.models.ColorQuestion
import com.multiplying_numbers.domain.multiple.models.ModelQuestions
import com.multiplying_numbers.domain.multiple.models.ModelSingleTab

class RecyclerViewSingleTab(
    private val modelSingleTab: ModelSingleTab
) : RecyclerView.Adapter<RecyclerViewSingleTab.TableHolderREFACTOR>() {

    class TableHolderREFACTOR(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemTextViewRvBinding.bind(view)
        fun initView(modelSingleTabREFACTOR: ModelQuestions) {
            binding.tv.apply {
                text = modelSingleTabREFACTOR.questionsString
                setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        when (modelSingleTabREFACTOR.colorQuestion) {
                            ColorQuestion.COLOR_DEFAULT -> android.R.color.black
                            ColorQuestion.COLOR_WRONG -> android.R.color.holo_red_dark
                            ColorQuestion.COLOR_CORRECT -> android.R.color.holo_green_dark
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
            .inflate(R.layout.item_text_view_rv, parent, false)
        return TableHolderREFACTOR(view = view)
    }

    override fun getItemCount() = modelSingleTab.listModelQuestions.size

    override fun onBindViewHolder(holder: TableHolderREFACTOR, position: Int) {
        val modelSingleTabREFACTOR = modelSingleTab.listModelQuestions[position]
        holder.initView(modelSingleTabREFACTOR = modelSingleTabREFACTOR)
    }
}