package com.multiplying_numbers.presentation.multiple.fragment.history_fragment_

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.IncludeTvAnswerItemForResultBinding
import com.multiplying_numbers.databinding.ItemResultAnswerRefactorBinding
import com.multiplying_numbers.domain.multiple.models.ColorCountWrongAnswer
import com.multiplying_numbers.domain.multiple.models.ColorQuestion
import com.multiplying_numbers.domain.multiple.models.ItemHistory
import com.multiplying_numbers.domain.multiple.models.ModelHistory
import com.multiplying_numbers.domain.multiple.models.ModelQuestions
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
        val modelHistory = modelHistory.listHistory[position]
        holder.initView(modelHistory = modelHistory)
    }


    class HistoryHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemResultAnswerRefactorBinding.bind(view)
        fun initView(modelHistory: ItemHistory) {
            setLabel(modelHistory = modelHistory)
            binding.label.tvDate.text = formatDate(time = modelHistory.date)
            getListIncludeView(binding = binding).forEachIndexed { index, include ->
                val modelQuestions = modelHistory.listAnswer[index]
                setQuestion(modelQuestions, include)
                setAnswer(modelQuestions, include)
            }
        }
        /** otherfun _____________________________________________________________________________*/
        private fun setQuestion(
            modelQuestions: ModelQuestions,
            include: IncludeTvAnswerItemForResultBinding
        ) {
            val question = modelQuestions.answerString
            include.tvQuestion.text = question
        }

        private fun setAnswer(
            modelQuestions: ModelQuestions,
            include: IncludeTvAnswerItemForResultBinding
        ) {
            val wrongAnswer =
                view.context.getString(R.string.wrong_answer) + " ${modelQuestions.countWrongAnswer}"
            include.tvWrongAnswer.apply {
                text = wrongAnswer
                setTextColor(
                    view.context.getColor(
                        when (modelQuestions.colorQuestion) {
                            ColorQuestion.COLOR_DEFAULT -> android.R.color.black
                            ColorQuestion.COLOR_WRONG -> android.R.color.holo_red_dark
                            ColorQuestion.COLOR_CORRECT -> android.R.color.holo_green_dark
                        }
                    )
                )
            }
        }

        private fun setLabel(modelHistory: ItemHistory) {
            var label = ""
            var color: Int? = null
            if (modelHistory.hasWrongAnswer) {
                label = view.context.getString(R.string.label_wrong_answer)
                color = view.context.getColor(android.R.color.holo_red_dark)
            } else {
                label = view.context.getString(R.string.label_all_answer_is_correct)
                color = view.context.getColor(android.R.color.holo_green_dark)
            }
            binding.label.tvLabel.apply {
                text = label
                setTextColor(color)
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