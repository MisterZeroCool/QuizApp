package ru.malohelm.quizapp.data.entity

import android.icu.text.CaseMap.Title
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "question")
data class Question(
//    @PrimaryKey(autoGenerate = true)
//    var id:Long? = null,
//
//    @ColumnInfo(name = "description")
//    val descriptionQuestion: String,

    var description: String = "",
    var option1: String = "",
    var option2: String = "",
    var option3: String = "",
    var option4: String = "",
    var answer: String = "",
    var userAnswer: String = "",
)
