package year2024.day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import parseTextToLists
import kotlin.io.path.Path
import kotlin.io.path.readLines

class Year2024Day1KtTest {

    @Test
    fun `part 1 - Example from advent of code`() {
        val input = listOf(
            "3   4",
            "4   3",
            "2   5",
            "1   3",
            "3   9",
            "3   3"
        )

        val result = calcTotalDistance(parseTextToLists(input))
        assertEquals(11, result)
    }

    @Test
    fun `part 1 - Part of the input`() {
        val input = listOf(
            "76594   45618",
            "39877   65376",
            "31586   50491"
        )

//        31586, 39877, 76594
//        45618, 50491, 65376
//        14032 + 10614 + 11218
        val result = calcTotalDistance(parseTextToLists(input))
        assertEquals(35864, result)
    }

    @Test
    fun `part 1 - Full input - should always return the correct answer to advent of code`() {
        val input = Path("src/main/kotlin/year2024/day1/input.txt").readLines()
        val result = calcTotalDistance(parseTextToLists(input))
        assertEquals(2164381, result)
    }

    @Test
    fun `part 2 - Calc similarity - example list on advent of code site`() {
        val input = listOf(
            "3   4",
            "4   3",
            "2   5",
            "1   3",
            "3   9",
            "3   3"
        )
        val result = calculateSimilarity(parseTextToLists(input))
        assertEquals(31, result)
    }

    @Test
    fun `part 2 - Full input - should always return the correct answer to advent of code`() {
        val input = Path("src/main/kotlin/year2024/day1/input.txt").readLines()
        val result = calculateSimilarity(parseTextToLists(input))
        assertEquals(20719933, result)
    }
}