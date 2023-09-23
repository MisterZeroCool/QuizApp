package ru.malohelm.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.malohelm.quizapp.data.db.MainDB
import ru.malohelm.quizapp.data.entity.Question

import ru.malohelm.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = MainDB.getDb(this)

        binding.btsave.setOnClickListener {
            val question = Question(
                null,
                binding.editName.text.toString(),
            )
            Thread{
                db.getDao().insertQuestion(question)
            }.start()

        }
    }
}