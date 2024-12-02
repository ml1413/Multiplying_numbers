package com.multiplying_numbers.presentation.multiple.fragment.history_fragment_

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ItemResultAnswerRefactorBinding
import com.multiplying_numbers.domain.multiple.models.ItemHistory
import com.multiplying_numbers.domain.multiple.models.ModelHistory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HistoryRecyclerView(
    private val modelHistory: ModelHistory
) :
    RecyclerView.Adapter<HistoryRecyclerView.HistoryHolder>() {


    override fun getItemCount() = modelHistory.listHistory.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_result_answer_refactor, parent, false)
        return HistoryHolder(view = view)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val modelHistory = modelHistory .listHistory[position]
        holder.initView(modelHistory = modelHistory)
    }

    /** otherfun _________________________________________________________________________________*/
    class HistoryHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemResultAnswerRefactorBinding.bind(view)
        fun initView(modelHistory: ItemHistory) {
            val label =
                view.context.getString(
                    if (modelHistory.hasWrongAnswer)
                        R.string.label_wrong_answer
                    else
                        R.string.label_all_answer_is_correct
                )
            binding.label.tvLabel.text = label
            binding.label.tvDate.text = formatDate(time = modelHistory.date)
            getListIncludeView(binding = binding).forEachIndexed { index, include ->
                val modelQuestions = modelHistory.listAnswer[index]
                val question = modelQuestions.answerString
                include.tvQuestion.text = question
                val wrongAnswer =
                    view.context.getString(R.string.wrong_answer) + " ${modelQuestions.countWrongAnswer}"
                include.tvWrongAnswer.text = wrongAnswer

            }
        }

        private fun getListIncludeView(binding: ItemResultAnswerRefactorBinding) =
            listOf(
                binding.includeItemTab0,
                binding.includeItemTab1,
                binding.includeItemTab2,
                binding.includeItemTab3,
                binding.includeItemTab4,
                binding.includeItemTab5,
                binding.includeItemTab6,
                binding.includeItemTab7,
                binding.includeItemTab8,
                binding.includeItemTab9
            )

        private fun formatDate(time: Long) =
            SimpleDateFormat("YYYY MM dd  HH:mm:ss", Locale.getDefault()).format(Date(time))
    }
}