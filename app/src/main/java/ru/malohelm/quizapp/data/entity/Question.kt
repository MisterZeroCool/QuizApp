package ru.malohelm.quizapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question")
data class Question(
    @PrimaryKey(autoGenerate = true)
    var id:Long? = null,

    @ColumnInfo(name = "description")
    val descriptionQuestion: String,
)
