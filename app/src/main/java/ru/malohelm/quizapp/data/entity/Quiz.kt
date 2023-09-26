package ru.malohelm.quizapp.data.entity

data class Quiz(
    var id: String = "",
    var title: String = "",
    var questions: MutableMap<String, Question> = mutableMapOf(),
)
