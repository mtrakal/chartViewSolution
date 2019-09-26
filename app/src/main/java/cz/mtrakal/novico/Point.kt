package cz.mtrakal.novico

import androidx.annotation.IntRange

data class Point(
    @IntRange(from = 0, to = 100)
    val x: Int,
    @IntRange(from = 0, to = 100)
    val y: Int
)