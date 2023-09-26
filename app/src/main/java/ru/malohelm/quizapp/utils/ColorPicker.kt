package ru.malohelm.quizapp.utils

object ColorPicker {
    private val colors = arrayOf(
        "#3EB9DF",
        "#D36280",
        "#E44F55",
        "#FA8056",
        "#818BCA",
        "#7D659F",
        "#51BAB3",
        "#E3AD17",
        "#EF8EAD",
        "#B5BFC6",)
    private var currentColorIndex = 0

    fun getColor(): String{
        currentColorIndex = (currentColorIndex + 1) % colors.size
        return colors[currentColorIndex]
    }
}