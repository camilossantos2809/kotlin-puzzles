package year2024.day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Year2024Day1KtTest {

    @Test
    fun `part 1 - Example from advent of code`() {
        val input = """3   4
4   3
2   5
1   3
3   9
3   3"""

        val result = calcTotalDistance(input)
        assertEquals(11, result)
    }

    @Test
    fun `part 1 - Part of the input`() {
        val input = """76594   45618
39877   65376
31586   50491"""

//        31586, 39877, 76594
//        45618, 50491, 65376
//        14032 + 10614 + 11218
        val result = calcTotalDistance(input)
        assertEquals(35864, result)
    }
}