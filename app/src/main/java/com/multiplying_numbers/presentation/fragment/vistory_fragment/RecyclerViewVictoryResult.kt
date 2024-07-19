package com.multiplying_numbers.presentation.fragment.vistory_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ItemResultAnswerRefactorBinding
import com.multiplying_numbers.domain.models.ModelItemVictory
import com.multiplying_numbers.domain.models.ModelQuestions
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class RecyclerViewVictoryResult(
    private val listModelItemVictory: List<ModelItemVictory>
) : RecyclerView.Adapter<RecyclerViewVictoryResult.HolderResultAnswer>() {


    override fun getItemCount(): Int {
        return listModelItemVictory.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderResultAnswer {
        return HolderResultAnswer(
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_result_answer_refactor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HolderResultAnswer, position: Int) {
        holder.initView(modelItemVictory = listModelItemVictory[position])
    }


    // resultAnswerHolder___________________________________________________________________________

    class HolderResultAnswer(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemResultAnswerRefactorBinding.bind(view)
        fun initView(modelItemVictory: ModelItemVictory) {

            binding.label.tvDate.text = formatDate(time = modelItemVictory.date)

            binding.label.tvLabel.apply {
                text = setLabel(modelItemVictory = modelItemVictory, context = context)
                getColorForLAbel(modelItemVictory = modelItemVictory)
                    .apply { setTextColor(ContextCompat.getColor(context, this)) }
            }

            getListIncludeView(binding = binding)
                .forEachIndexed { index, includeTvAnswerItemForResultBinding ->
                    val model = modelItemVictory.listAnswer[index]

                    includeTvAnswerItemForResultBinding.tvAnswer.apply {
                        text = setTestItTvAnswer(model = model, context)
                        getColorAnswer(model = model)
                            .apply { setTextColor(ContextCompat.getColor(context, this)) }
                    }

                    includeTvAnswerItemForResultBinding.tvQuestion.apply {
                        text = model.answer
                        getColorAnswer(model = model)
                            .apply { setTextColor(ContextCompat.getColor(context, this)) }
                    }

                }

        }


        /**otherFun______________________________________________________________________________*/
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

        private fun setTestItTvAnswer(model: ModelQuestions, context: Context) =
            context.getString(R.string.wrong_answer) + " : ${model.countWrongAnswer}"

        private fun formatDate(time: Long) =
            SimpleDateFormat("YYYY MM dd", Locale.getDefault()).format(Date(time))

        private fun getColorAnswer(model: ModelQuestions) =
            if (model.countWrongAnswer>0) android.R.color.holo_red_dark
            else android.R.color.holo_green_dark

        private fun setLabel(modelItemVictory: ModelItemVictory, context: Context) =
            if (modelItemVictory.hasWrongAnswer) context.getString(R.string.label_wrong_answer)
            else context.getString(R.string.label_all_answer_is_correct)

        private fun getColorForLAbel(modelItemVictory: ModelItemVictory) =
            if (modelItemVictory.listAnswer.sumOf { it.countWrongAnswer } > 0) android.R.color.holo_red_dark
            else android.R.color.holo_green_dark

    }
}