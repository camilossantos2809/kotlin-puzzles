package year2024.day3

import services.fileSystem.FileHelper
import kotlin.test.Test
import kotlin.test.assertEquals

const val inputPath = "inputs/input-3.txt"
const val exampleDay1 = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
const val exampleDay2 = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

class Year2024Day3KtTest {

    @Test
    fun `calcMulValue - should multiply the numbers from the input string`() {
        val result = calcMulValue("mul(266,969)")
        assertEquals(257754, result)
    }

    @Test
    fun `extractMulValues - should return a list of mul values`() {
        val result = extractMulValues(exampleDay1)
        assertEquals(listOf("mul(2,4)", "mul(5,5)", "mul(11,8)", "mul(8,5)"), result)
    }

    @Test
    fun `sumAllMulValues - Example from advent of code day 1`() {
        val result = sumAllMulValues(exampleDay1)
        assertEquals(161, result)
    }

    @Test
    fun `part 1 - Full input - should always return the correct answer to advent of code`() {
        val input = FileHelper.readLines(inputPath)
        val result = sumAllMulValues(input.joinToString())
        assertEquals(159892596, result)
    }

    @Test
    fun `extractedFilteredMulValues - should return a list of mul values that are not between 'don't' and 'do'`() {
        val result = extractedFilteredMulValues(exampleDay2)
        assertEquals(listOf("mul(2,4)", "mul(8,5)"), result)
    }

    @Test
    fun `sumAllMulValuesFiltered - Example from advent of code day 2`() {
        val result = sumAllMulValuesFiltered(exampleDay2)
        assertEquals(48, result)
    }

    @Test
    fun `part 2 - Full input - should always return the correct answer to advent of code`() {
        val input = FileHelper.readLines(inputPath)
        val result = sumAllMulValuesFiltered(input.joinToString())
        assertEquals(92626942, result)
    }
}