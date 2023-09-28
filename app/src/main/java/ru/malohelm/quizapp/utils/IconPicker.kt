package ru.malohelm.quizapp.utils

import ru.malohelm.quizapp.R

object IconPicker {
    private val icons = arrayOf(
        R.drawable.ic_java,
        R.drawable.ic_js,
        R.drawable.ic_php,
        R.drawable.ic_c_sharp,
        R.drawable.ic_android,
        R.drawable.ic_c_plus,
        R.drawable.ic_kotlin,
        R.drawable.ic_ios,
        R.drawable.ic_c,)
    private var currentIconIndex = 0

    fun getIcon(): Int {
        currentIconIndex = (currentIconIndex + 1) % icons.size
        return icons[currentIconIndex]
    }
}