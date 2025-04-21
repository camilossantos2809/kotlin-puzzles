package year2024.day4

import services.fileSystem.FileHelper
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

const val inputPath = "inputs/input-4.txt"
const val examplePart1 = """MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MSAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX"""

const val partialInput =
    """XXXMMSAMXXMASXASAMMSMMSAAMXMAXSAXMSXMXSAXMMXXXXMXAXXXMASMMSSSSSMMMSMSMMSMSMSMMSXMXMMSMMMMAMXSMMMMSSXMASXSMAMSMAXMAMXSXAMSSMSSSMXSMSXXXXAXMMM
AMSMMASAMXXXXAXMAXAAMSAXXMXAMAMXAMMAMAMMSMSMXXASXSMMSMMSAMAAAMXMAMAAMMMSASXXMASAMXMMMAMXSAMMMAXMMAMAMASAMXASAMMMSAMXMMMAAAAAAAMASMXMSMSMMSAM
MAAAMAXXASMMASASMMSSSXAXMXSAMASMSMMSMAXAAAAAMSMMAMXAAAAXAMMMMMASASMSMMAMAMSXMASAMMXASAMXSASMSSMSMSXSMAMXMSXSASAXMAMAAAXMSSMMSMMASAMXSAAAASAS
XSMSMSSMXAAMAXMASMXMMMMSAMXXSMSAMXAMSSSSMSMSMAAMAMMXSXMMSMASASXSXSXMAMXXSAMXMASXXASMSASMSAMAXMAAXMAMMSMSXMXSXMASXXSXMXSAMXMAMAMXSASAMXMMMSXM
XXSXXAAXSSSMSSXMMMAXMASMMMMXMAMMMMXXAMAXAAAAMMMMASAAXASAXMASASXSASASXMAMAASMSAMAMXSMSAMXMAMMMMXMSMMMAMXMAMAMAMSSXMAMMSAMXAMMMAMASAMMSASAMXAA"""


class Year2024Day4KtTest {
    @Test
    fun `part 1 - Should return correct answer based on example from advent of code`() {
        val result = countXMAS(examplePart1.lines())
        assertEquals(18, result)
    }

    @Test
    fun `part 2 - Should return correct answer based on example from advent of code`() {
        val result = countXMASPart2(examplePart1)
        assertEquals(9, result)
    }

    @Test
    fun `Should return correct count of line matches`() {
        val result = partialInput.lines().sumOf { countLineMatches(it) }
        assertEquals(10, result)
    }

    @Test
    fun `Should return correct count of line matches based on example from advent of code`() {
        val result = countLineMatches(examplePart1)
        assertEquals(3, result)
    }

    @Test
    fun `Should return correct count of line matches reversed`() {
        val result = partialInput.lines().sumOf { countLineMatchesReversed(it) }
        assertEquals(15, result)
    }

    @Test
    fun `Should return correct count of line matches reversed based on example from advent of code`() {
        val result = countLineMatchesReversed(examplePart1)
        assertEquals(2, result)
    }

    @Test
    fun `Should return a text with the columns converted to lines`() {
        val result = convertColumnsToLines(
            """
            123
            456
            789
        """.trimIndent()
        )
        val expected = listOf("147", "258", "369")
        assertEquals(expected, result)
    }

    @Test
    fun `Should count occurrences of a string by columns`() {
        val result = countColumnMatches(partialInput)
        assertEquals(3, result)
    }

    @Test
    fun `Should count occurrences of a string by columns but reversed`() {
        val result = countColumnMatchesReversed(examplePart1)
        assertEquals(2, result)
    }

    @Test
    fun `Should return a list of lines with the columns on diagonal converted to lines`() {
        val result = convertColumnsOnDiagonalToLines(
            """
            123456
            789012
            345678
            901234
        """.trimIndent()
        )
        val expected = listOf("9", "30", "741", "1852", "2963", "3074", "418", "52", "6")
        assertEquals(expected, result)
    }

    @Test
    fun `Should return a list of lines with the columns on diagonal converted to lines but reversed`() {
        val result = convertColumnsOnDiagonalToLines(
            """
            123456
            789012
            345678
            901234
        """.trimIndent(), reverse = true
        )
        val expected = listOf("1", "27", "383", "4949", "5050", "6161", "272", "83", "4")
        assertEquals(expected, result)
    }

    @Test
    fun `Should count occurrences of a string by columns on diagonal`() {
        val result = countDiagonalMatches(examplePart1)
        assertEquals(1 + 4, result)
    }

    @Test
    fun `Should count occurrences of a string by columns on diagonal reversed`() {
        val result = countDiagonalMatchesReversed(examplePart1)
        assertEquals(1 + 4, result)
    }

    @Test
    fun `part 1 - Full input - should always return the correct answer to advent of code`() {
        val input = FileHelper.readLines(inputPath)
        val result = countXMAS(input)
        assertTrue(result > 438, "Expect to be greater than 438 since this first attempt is wrong")
        assertEquals(2575, result)
    }

    @Test
    fun `part 2 - Full input - should always return the correct answer to advent of code`() {
        val input = FileHelper.readLines(inputPath).joinToString("\n")
        val result = countXMASPart2(input)
        assertEquals(2041, result)
    }

}