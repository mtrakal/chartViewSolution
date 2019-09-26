package cz.mtrakal.novico

data class Chart(
    val point1: Point,
    val point2: Point,
    val color: RgbColor
    // in this class missing validation, that point1 is on lower position than point2
)