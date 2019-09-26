package cz.mtrakal.novico

class View(private val chart1: Chart, private val chart2: Chart) {
    fun doChartsOverlap(): Boolean = when {
        chart1.point1.x > chart2.point2.x || chart2.point1.x > chart1.point2.x -> false
        chart1.point1.y > chart2.point2.y || chart2.point1.y > chart1.point2.y -> false
        else -> true
    }

    fun getColour(x: Int, y: Int): RgbColor {
        val point = Point(x, y)
        val inChart1 = isPointInChart(point, chart1)
        val inChart2 = isPointInChart(point, chart2)
        return when {
            inChart1 && inChart2 -> calculateAvgColor(chart1.color, chart2.color)
            inChart1 -> chart1.color
            inChart2 -> chart2.color
            else -> DEFAULT_COLOR
        }
    }

    private fun calculateAvgColor(color1: RgbColor, color2: RgbColor): RgbColor {
        val r: Int = (color1.r + color2.r) / 2
        val g: Int = (color1.g + color2.g) / 2
        val b: Int = (color1.b + color2.b) / 2
        return RgbColor(r, g, b)
    }

    private fun isPointInChart(point: Point, chart: Chart): Boolean =
        chart.point1.x < point.x && chart.point1.y < point.y
                && chart.point2.x >= point.x && chart.point2.y >= point.y

    companion object {
        val DEFAULT_COLOR: RgbColor = RgbColor(0, 0, 0)
    }
}