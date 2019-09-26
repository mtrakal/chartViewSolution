package cz.mtrakal.novico

import androidx.annotation.IntRange

data class RgbColor(
    @IntRange(from = 0, to = 255)
    val r: Int,
    @IntRange(from = 0, to = 255)
    val g: Int,
    @IntRange(from = 0, to = 255)
    val b: Int

)