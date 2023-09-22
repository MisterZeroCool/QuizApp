package ru.malohelm.quizapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "answer")
class Answer(
    @PrimaryKey(autoGenerate = true)
    val id:Long? = null ,

    @ColumnInfo(name = "description")
    val descriptionAnswer: String,
)