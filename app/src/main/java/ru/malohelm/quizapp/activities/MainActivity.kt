package ru.malohelm.quizapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.GridLayoutManager
import ru.malohelm.quizapp.R
import ru.malohelm.quizapp.adapters.QuizAdapter
import ru.malohelm.quizapp.data.entity.Quiz
import ru.malohelm.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<Quiz>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateDummyData()
        setUpViews()
    }

    private fun populateDummyData(){
        quizList.add(Quiz("12-09-2023", "12-09-2023"))
        quizList.add(Quiz("13-09-2023", "13-09-2023"))
        quizList.add(Quiz("14-09-2023", "14-09-2023"))
        quizList.add(Quiz("15-09-2023", "15-09-2023"))
        quizList.add(Quiz("16-09-2023", "16-09-2023"))
        quizList.add(Quiz("17-09-2023", "17-09-2023"))
        quizList.add(Quiz("18-09-2023", "18-09-2023"))
        quizList.add(Quiz("19-09-2023", "19-09-2023"))
        quizList.add(Quiz("20-09-2023", "20-09-2023"))
        quizList.add(Quiz("21-09-2023", "21-09-2023"))
        quizList.add(Quiz("22-09-2023", "22-09-2023"))
        quizList.add(Quiz("23-09-2023", "23-09-2023"))
    }

    private fun setUpViews(){
        setUpDrawerLayout()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        adapter = QuizAdapter(this, quizList)
        binding.quizRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.quizRecyclerView.adapter = adapter
    }

    private fun setUpDrawerLayout(){
        setSupportActionBar(binding.appBar)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.mainDrawer,
            R.string.app_name,
            R.string.app_name
        )
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}