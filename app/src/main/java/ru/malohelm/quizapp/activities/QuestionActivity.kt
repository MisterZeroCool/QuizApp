package ru.malohelm.quizapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ru.malohelm.quizapp.R
import ru.malohelm.quizapp.adapters.OptionAdapter
import ru.malohelm.quizapp.data.entity.Question
import ru.malohelm.quizapp.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindViews()
    }

    private fun bindViews() {
        val question = Question(
            "Java объектно ориентированный язык?",
            "Да",
            "Нет",
            "Возможно",
            "Незнаю",
            "Да"
        )
        binding.description.text = question.description
        val optionAdapter = OptionAdapter(this, question)
        binding.optionList.layoutManager = LinearLayoutManager(this)
        binding.optionList.adapter = optionAdapter
        binding.optionList.setHasFixedSize(true)



    }

}