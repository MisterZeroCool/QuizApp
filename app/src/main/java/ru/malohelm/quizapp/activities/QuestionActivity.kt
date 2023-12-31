package ru.malohelm.quizapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import ru.malohelm.quizapp.R
import ru.malohelm.quizapp.adapters.OptionAdapter
import ru.malohelm.quizapp.data.entity.Question
import ru.malohelm.quizapp.data.entity.Quiz
import ru.malohelm.quizapp.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuestionBinding
    var quiz: MutableList<Quiz>? = null
    var questions: MutableMap<String, Question>? = null
    var index = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpFirestore()
        setUpEventListener()
    }

    private fun setUpEventListener() {
        binding.btnPrevious.setOnClickListener {
            index--
            bindViews()
        }
        binding.btnNext.setOnClickListener {
            index++
            bindViews()
        }

        binding.btnSubmit.setOnClickListener {
            Log.d("FINALQUIZ", questions.toString())

            val intent = Intent(this, ResultActivity::class.java)
            val json = Gson().toJson(quiz!![0])
            intent.putExtra("QUIZ", json)
            startActivity(intent)
        }
    }

    private fun setUpFirestore(){
        val firestore = FirebaseFirestore.getInstance()
        var data = intent.getStringExtra("DATE")
        if (data != null){
            firestore.collection("quizapp").whereEqualTo("title", data)
                .get()
                .addOnSuccessListener {
                    if (it != null && !it.isEmpty){
                        Log.d("DATA", it.toObjects(Quiz::class.java).toString())
                        quiz = it.toObjects(Quiz::class.java)
                        questions = quiz!![0].questions
                        bindViews()
                    }

                }
        }


    }

    private fun bindViews() {
        binding.btnPrevious.visibility = View.GONE
        binding.btnSubmit.visibility = View.GONE
        binding.btnNext.visibility = View.GONE

        if (index == 1){
            binding.btnNext.visibility = View.VISIBLE
        }
        else if (index == questions!!.size){
            binding.btnSubmit.visibility = View.VISIBLE
            binding.btnPrevious.visibility = View.VISIBLE
        }
        else{
            binding.btnPrevious.visibility = View.VISIBLE
            binding.btnNext.visibility = View.VISIBLE
        }

        val question = questions!!["question$index"]
        question?.let {
            binding.description.text = it.description
            val optionAdapter = OptionAdapter(this, it)
            binding.optionList.layoutManager = LinearLayoutManager(this)
            binding.optionList.adapter = optionAdapter
            binding.optionList.setHasFixedSize(true)
        }




    }

}