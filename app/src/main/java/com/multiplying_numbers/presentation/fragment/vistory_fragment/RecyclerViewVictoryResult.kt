package com.multiplying_numbers.presentation.fragment.vistory_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ItemResultAnswerRefactorBinding
import com.multiplying_numbers.domain.models.ModelItemVictory

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
            binding.label.tvLabel.text = modelItemVictory.label
            binding.label.tvDate.text = modelItemVictory.date.toString()

            binding.tv0.tvQuestion.text = modelItemVictory.listAnswer[0].answer
            binding.tv1.tvQuestion.text = modelItemVictory.listAnswer[1].answer
            binding.tv2.tvQuestion.text = modelItemVictory.listAnswer[2].answer
            binding.tv3.tvQuestion.text = modelItemVictory.listAnswer[3].answer
            binding.tv4.tvQuestion.text = modelItemVictory.listAnswer[4].answer
            binding.tv5.tvQuestion.text = modelItemVictory.listAnswer[5].answer
            binding.tv6.tvQuestion.text = modelItemVictory.listAnswer[6].answer
            binding.tv7.tvQuestion.text = modelItemVictory.listAnswer[7].answer
            binding.tv8.tvQuestion.text = modelItemVictory.listAnswer[8].answer
            binding.tv9.tvQuestion.text = modelItemVictory.listAnswer[9].answer

            binding.tv0.tvAnswer.text ="wrong Answer -"+ modelItemVictory.listAnswer[0].countWrongAnswer.toString()
            binding.tv1.tvAnswer.text ="wrong Answer -"+ modelItemVictory.listAnswer[1].countWrongAnswer.toString()
            binding.tv2.tvAnswer.text ="wrong Answer -"+ modelItemVictory.listAnswer[2].countWrongAnswer.toString()
            binding.tv3.tvAnswer.text ="wrong Answer -"+ modelItemVictory.listAnswer[3].countWrongAnswer.toString()
            binding.tv4.tvAnswer.text ="wrong Answer -"+ modelItemVictory.listAnswer[4].countWrongAnswer.toString()
            binding.tv5.tvAnswer.text ="wrong Answer -"+ modelItemVictory.listAnswer[5].countWrongAnswer.toString()
            binding.tv6.tvAnswer.text ="wrong Answer -"+ modelItemVictory.listAnswer[6].countWrongAnswer.toString()
            binding.tv7.tvAnswer.text ="wrong Answer -"+ modelItemVictory.listAnswer[7].countWrongAnswer.toString()
            binding.tv8.tvAnswer.text ="wrong Answer -"+ modelItemVictory.listAnswer[8].countWrongAnswer.toString()
            binding.tv9.tvAnswer.text ="wrong Answer -"+ modelItemVictory.listAnswer[9].countWrongAnswer.toString()


        }
    }
}