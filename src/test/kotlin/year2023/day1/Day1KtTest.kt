package year2023.day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1KtTest {

    @Test
    fun part_1() {
        val input = """1abc2
         pqr3stu8vwx
         a1b2c3d4e5f
         treb7uchet"""

        assertEquals(142, calibration(input))
    }

    @Test
    fun `part 1 - when no digit was found`() {
        val input = """abc
            def
            ghi
        """

        assertEquals(0, calibration(input))
    }

    @Test
    fun part_2() {
        val input = """two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen"""

        assertEquals(281, calibration(input))
    }
}