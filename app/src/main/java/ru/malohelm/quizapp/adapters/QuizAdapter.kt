package ru.malohelm.quizapp.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ru.malohelm.quizapp.R
import ru.malohelm.quizapp.activities.QuestionActivity
import ru.malohelm.quizapp.data.entity.Quiz
import ru.malohelm.quizapp.utils.ColorPicker
import ru.malohelm.quizapp.utils.IconPicker

class QuizAdapter(val context: Context, val quiz: List<Quiz>) :RecyclerView.Adapter<QuizAdapter.QuizViewHolder>(){
    inner class QuizViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var textViewTitle: TextView = itemView.findViewById(R.id.quizTitle)
        var iconView: ImageView = itemView.findViewById(R.id.quizIcon)
        var cardContainer: CardView = itemView.findViewById(R.id.cardContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.quiz_item, parent, false)
        return QuizViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quiz.size
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.textViewTitle.text = quiz[position].title
        holder.cardContainer.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()))
        holder.iconView.setImageResource(IconPicker.getIcon())
        holder.itemView.setOnClickListener {
            Toast.makeText(context, quiz[position].title, Toast.LENGTH_SHORT).show()
            val  intent = Intent(context, QuestionActivity::class.java)
            intent.putExtra("DATE", quiz[position].title)
            context.startActivity(intent)
        }
    }


}