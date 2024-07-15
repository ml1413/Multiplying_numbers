package com.multiplying_numbers.presentation.fragment.vistory_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ItemModelResultAnswerBinding
import com.multiplying_numbers.databinding.ItemResultAnswerBinding
import com.multiplying_numbers.domain.models.ModelWrapper
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class RecyclerViewVictoryResult(
    private val listLabelAndModelAnswer: List<ModelWrapper>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (listLabelAndModelAnswer[position]) {
            is ModelWrapper.ModelLabel -> 1
            is ModelWrapper.ModelQuestion -> 2
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_model_result_answer, parent, false)
                DataViewHolder(view)
            }

            2 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_result_answer, parent, false)
                ResultAnswerHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DataViewHolder -> holder
                .initView(
                    modelWrapper =
                    listLabelAndModelAnswer[position] as ModelWrapper.ModelLabel
                )

            is ResultAnswerHolder -> holder
                .initView(
                    modelWrapper =
                    listLabelAndModelAnswer[position] as ModelWrapper.ModelQuestion
                )
        }
    }


    override fun getItemCount() = listLabelAndModelAnswer.size

    // resultAnswerHolder___________________________________________________________________________
    class ResultAnswerHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemResultAnswerBinding.bind(view)
        fun initView(modelWrapper: ModelWrapper.ModelQuestion) {
            binding.tvCount.text = modelWrapper.modelQuestions.countWrongAnswer.toString()
            binding.tvAnswer.text = modelWrapper.modelQuestions.answer
        }
    }

    class DataViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemModelResultAnswerBinding.bind(view)
        fun initView(modelWrapper: ModelWrapper.ModelLabel) {
            val data = Date(modelWrapper.modelLabelResultAnswer.date)
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
            binding.tvData.text = sdf.format(data)

            val color =
                if (modelWrapper.modelLabelResultAnswer.hasWrongAnswer)
                    android.R.color.holo_red_dark
                else
                    android.R.color.holo_green_dark

            val string =
                if (modelWrapper.modelLabelResultAnswer.hasWrongAnswer)
                    "there are wrong answers here"
                else
                    "Great"
            binding.tvLabel.apply {
                setTextColor(ContextCompat.getColor(view.context, color))
                text = string
            }
        }
    }

}