package cz.mtrakal.novico

import org.junit.Assert.*
import org.junit.Test

class ViewTest {
    @Test
    fun notOverlapTest() {
        val chart1 = Chart(Point(0, 0), Point(10, 10), RgbColor(0, 0, 0))
        val chart2 = Chart(Point(20, 20), Point(30, 30), RgbColor(0, 0, 0))
        assertEquals(View(chart1, chart2).doChartsOverlap(), false)
    }

    @Test
    fun overlapTest() {
        val chart1 = Chart(Point(0, 0), Point(10, 10), RgbColor(0, 0, 0))
        val chart2 = Chart(Point(5, 5), Point(30, 30), RgbColor(0, 0, 0))
        assertEquals(View(chart1, chart2).doChartsOverlap(), true)
    }

    @Test
    fun notOverlapColorChart1Test() {
        val chart1 = Chart(Point(0, 0), Point(10, 10), RgbColor(30, 20, 10))
        val chart2 = Chart(Point(20, 20), Point(30, 30), RgbColor(0, 0, 0))
        assertEquals(View(chart1, chart2).getColour(9, 9), RgbColor(30, 20, 10))
    }

    @Test
    fun notOverlapColorChart2Test() {
        val chart1 = Chart(Point(0, 0), Point(10, 10), RgbColor(30, 20, 10))
        val chart2 = Chart(Point(20, 20), Point(30, 30), RgbColor(10, 20, 30))
        assertEquals(View(chart1, chart2).getColour(22, 22), RgbColor(10, 20, 30))
    }

    @Test
    fun overlapColorTest() {
        val chart1 = Chart(Point(0, 0), Point(10, 10), RgbColor(20, 30, 40))
        val chart2 = Chart(Point(5, 5), Point(30, 30), RgbColor(220, 230, 240))
        assertEquals(View(chart1, chart2).getColour(8, 8), RgbColor(120, 130, 140))
    }

    // of course require much more tests for corner cases...
}