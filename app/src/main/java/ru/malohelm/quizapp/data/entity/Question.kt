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
    var optionl1: String = "",
    var optionl2: String = "",
    var optionl3: String = "",
    var optionl4: String = "",
    var answer: String = "",
    var userAnswer: String = "",
)
