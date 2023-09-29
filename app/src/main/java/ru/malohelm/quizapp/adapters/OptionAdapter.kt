package ru.malohelm.quizapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.malohelm.quizapp.R
import ru.malohelm.quizapp.data.entity.Question

class OptionAdapter(val context: Context, val question: Question): RecyclerView.Adapter<OptionAdapter.OptionViewHolder>(){

    private var options: List<String> = listOf(question.optionl1, question.optionl2, question.optionl3, question.optionl4)
    inner class OptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var optionView = itemView.findViewById<TextView>(R.id.quiz_option)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.option_item, parent, false)
        return OptionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return options.size
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.optionView.text = options[position]
        holder.itemView.setOnClickListener {
//            Toast.makeText(context, options[position], Toast.LENGTH_SHORT).show()
            question.userAnswer = options[position]
            notifyDataSetChanged()
        }
        if (question.userAnswer == options[position]){
            holder.itemView.setBackgroundResource(R.drawable.option_item_selected_bg)
        }
        else{
            holder.itemView.setBackgroundResource(R.drawable.option_item_bg)
        }
    }
}