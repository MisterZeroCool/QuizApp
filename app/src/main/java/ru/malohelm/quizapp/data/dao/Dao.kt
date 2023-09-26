//package ru.malohelm.quizapp.data.dao
//
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.Query
//import kotlinx.coroutines.flow.Flow
//import ru.malohelm.quizapp.data.entity.Answer
//import ru.malohelm.quizapp.data.entity.Question
//
//@Dao
//interface Dao {
//    @Insert
//    fun insertAnswer(answer: Answer)
//    @Insert
//    fun insertQuestion(question: Question)
//
//    @Delete
//    fun deleteAnswer(vararg answer: Answer)
//    @Delete
//    fun deleteQuestion(vararg question: Question)
//
//    @Query("SELECT description FROM answer")
//    fun getAllAnswers():Flow<List<Answer>>
//    @Query("SELECT description FROM question")
//    fun getAllQuestion():Flow<List<Question>>
//
//
//}