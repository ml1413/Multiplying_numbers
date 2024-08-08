package com.multiplying_numbers.presentation.fragment.single_table_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
    class TableHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemForTableRvBinding.bind(view)
        fun initView(modelQuestions: ModelQuestions) {
            binding.tv.apply {
                val colorAnswer = getColorAnswer(modelQuestions = modelQuestions)
                val textAnswer = getAnswerOrQuestionsText(modelQuestions = modelQuestions)
                setTextColor(colorAnswer)
                text = textAnswer
            }
        }
        //other fun_________________________________________________________________________________________

        private fun getAnswerOrQuestionsText(modelQuestions: ModelQuestions) =
            if (modelQuestions.isCorrect != null && modelQuestions.isCorrect) {
                modelQuestions.answer
            } else {
                modelQuestions.questions
            }

        private fun getColorAnswer(modelQuestions: ModelQuestions) =
            if (modelQuestions.isCorrect == null) {
                ContextCompat.getColor(
                    view.context,
                    android.R.color.black
                )
            } else if (modelQuestions.isCorrect) {
                ContextCompat.getColor(
                    view.context,
                    android.R.color.holo_green_dark
                )
            } else {
                ContextCompat.getColor(
                    view.context,
                    android.R.color.holo_red_dark
                )
            }
    }
}