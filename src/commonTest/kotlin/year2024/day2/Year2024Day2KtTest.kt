package year2024.day2


import FileHelper
import kotlin.test.Test
import kotlin.test.assertEquals

const val inputPath = "inputs/input-2.txt"

class Year2024Day2KtTest {
        private val inputExample = listOf(
            "7 6 4 2 1",
            "1 2 7 8 9",
            "9 7 6 2 1",
            "1 3 2 4 5",
            "8 6 4 4 1",
            "1 3 6 7 9",
        )

    @Test
    fun `Part 1 - Example from advent of code`() {
        val result = countTotalSafeReports(inputExample)
        assertEquals(2, result)
    }

    @Test
    fun `isAllIncreasing - Example from advent of code`() {
        assertEquals(false, isAllIncreasing(listOf(7, 6, 4, 2, 1)))
        assertEquals(true, isAllIncreasing(listOf(1, 2, 7, 8, 9)))
        assertEquals(false, isAllIncreasing(listOf(9, 7, 6, 2, 1)))
        assertEquals(false, isAllIncreasing(listOf(1, 3, 2, 4, 5)))
        assertEquals(false, isAllIncreasing(listOf(8, 6, 4, 4, 1)))
        assertEquals(true, isAllIncreasing(listOf(1, 3, 6, 7, 9)))
    }

    @Test
    fun `isAllDecreasing - Example from advent of code`(){
        assertEquals(true, isAllDecreasing(listOf(7, 6, 4, 2, 1)))
        assertEquals(false, isAllDecreasing(listOf(1, 2, 7, 8, 9)))
        assertEquals(true, isAllDecreasing(listOf(9, 7, 6, 2, 1)))
        assertEquals(false, isAllDecreasing(listOf(1, 3, 2, 4, 5)))
        assertEquals(false, isAllDecreasing(listOf(8, 6, 4, 4, 1)))
        assertEquals(false, isAllDecreasing(listOf(1, 3, 6, 7, 9)))
    }

    @Test
    fun `isAllIncreasing - should return false when two adjacent levels are the same`(){
        assertEquals(false, isAllIncreasing(listOf(1, 2, 3, 3, 4)))
    }

    @Test
    fun `isAllDecreasing - should return false when two adjacent levels are the same`(){
        assertEquals(false, isAllDecreasing(listOf(4, 3, 2, 2, 1)))
    }

    @Test
    fun `hasOnlyAllowedDiffs - Example from advent of code`(){
        assertEquals(true, hasOnlyAllowedDiffs(listOf(7, 6, 4, 2, 1)))
        assertEquals(false, hasOnlyAllowedDiffs(listOf(1, 2, 7, 8, 9)))
        assertEquals(false, hasOnlyAllowedDiffs(listOf(9, 7, 6, 2, 1)))
        assertEquals(true, hasOnlyAllowedDiffs(listOf(1, 3, 2, 4, 5)))
        assertEquals(false, hasOnlyAllowedDiffs(listOf(8, 6, 4, 4, 1)))
        assertEquals(true, hasOnlyAllowedDiffs(listOf(1, 3, 6, 7, 9)))
    }

    @Test
    fun `part 1 - Full input - should always return the correct answer to advent of code`() {
        val input = FileHelper.readLines(inputPath)
        val result = countTotalSafeReports(input)
        assertEquals(287, result)
    }

    @Test
    fun `part 2`(){
        val result = countSafeReportsRemovingOneLevel(inputExample)
        assertEquals(4, result)
    }

    @Test
    fun `part 2 - Full input - should always return the correct answer to advent of code`() {
        val input = FileHelper.readLines(inputPath)
        val result = countSafeReportsRemovingOneLevel(input)
        assertEquals(354, result)
    }
}