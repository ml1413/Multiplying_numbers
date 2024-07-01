package com.multiplying_numbers.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.multiplying_numbers.R
import com.multiplying_numbers.databinding.ItemForRecyclerBinding
import com.multiplying_numbers.domain.models.ModelQuestions

class RecyclerView(
    private val listModel: List<ModelQuestions>
) : RecyclerView.Adapter<MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_for_recycler, parent, false)
        return MyHolder(view = view)
    }

    override fun getItemCount() = listModel.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.initView(modelQuestions = listModel[position])
    }

}

//_________________________________________________________________________________________________
class MyHolder(private val view: View) : ViewHolder(view) {
    private val binding = ItemForRecyclerBinding.bind(view)
    fun initView(modelQuestions: ModelQuestions) {
        // set answer
        val stringAnswer =
            if (modelQuestions.isCorrect == null || modelQuestions.isCorrect == false) {
                modelQuestions.questionOnTable + "?"
            }else{
                modelQuestions.questionOnTable + modelQuestions.correctAnswer
            }
        binding.tv.text = stringAnswer

        //set color
        modelQuestions.isCorrect?.let {
            val color = if (it) android.R.color.holo_green_dark else android.R.color.holo_red_dark
            binding.tv.setTextColor(ContextCompat.getColor(view.context, color))
        }

    }
}