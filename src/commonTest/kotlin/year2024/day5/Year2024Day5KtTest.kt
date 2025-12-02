package year2024.day5


import kotlin.test.Test
import kotlin.test.assertEquals

const val inputPath = "inputs/input-5.txt"
const val exampleInput = """47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

75,47,61,53,29
97,61,53,29,13
75,29,13
75,97,47,61,53
61,13,29
97,13,75,29,47"""

class Year2024Day5KtTest {
    @Test
    fun `part 1 - Should return correct answer based on example from advent of code`() {
        val result = sumMiddlePages(exampleInput)
        assertEquals(143, result)
    }
}