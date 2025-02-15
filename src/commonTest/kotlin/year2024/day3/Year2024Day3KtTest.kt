package year2024.day3

import services.fileSystem.FileHelper
import kotlin.test.Test
import kotlin.test.assertEquals

const val inputPath = "inputs/input-3.txt"

class Year2024Day3KtTest {

    @Test
    fun `calcMulValue - should multiply the numbers from the input string`() {
        val result = calcMulValue("mul(266,969)")
        assertEquals(257754, result)
    }

    @Test
    fun `extractMulValues - should return a list of mul values`() {
        val result = extractMulValues("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")
        assertEquals(listOf("mul(2,4)", "mul(5,5)", "mul(11,8)", "mul(8,5)"), result)
    }

    @Test
    fun `sumAllMulValues - Example from advent of code day 1`() {
        val result = sumAllMulValues("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")
        assertEquals(161, result)
    }

    @Test
    fun `part 1 - Full input - should always return the correct answer to advent of code`() {
        val input = FileHelper.readLines(inputPath)
        val result = sumAllMulValues(input.joinToString())
        assertEquals(173529487, result)
    }
}