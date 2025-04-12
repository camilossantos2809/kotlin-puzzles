package year2024.day1


import parseTextToLists
import kotlin.test.Test
import kotlin.test.assertEquals
import services.fileSystem.FileHelper

const val inputPath = "inputs/input-1.txt"

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
        val input = FileHelper.readLines(inputPath)
        val result = calcTotalDistance(parseTextToLists(input))
        assertEquals(1651298, result)
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
        val input = FileHelper.readLines(inputPath)
        val result = calculateSimilarity(parseTextToLists(input))
        assertEquals(21306195, result)
    }
}