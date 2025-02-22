package year2024.day4

import services.fileSystem.FileHelper
import kotlin.test.Test
import kotlin.test.assertEquals

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

const val partialInput = """XXXMMSAMXXMASXASAMMSMMSAAMXMAXSAXMSXMXSAXMMXXXXMXAXXXMASMMSSSSSMMMSMSMMSMSMSMMSXMXMMSMMMMAMXSMMMMSSXMASXSMAMSMAXMAMXSXAMSSMSSSMXSMSXXXXAXMMM
AMSMMASAMXXXXAXMAXAAMSAXXMXAMAMXAMMAMAMMSMSMXXASXSMMSMMSAMAAAMXMAMAAMMMSASXXMASAMXMMMAMXSAMMMAXMMAMAMASAMXASAMMMSAMXMMMAAAAAAAMASMXMSMSMMSAM
MAAAMAXXASMMASASMMSSSXAXMXSAMASMSMMSMAXAAAAAMSMMAMXAAAAXAMMMMMASASMSMMAMAMSXMASAMMXASAMXSASMSSMSMSXSMAMXMSXSASAXMAMAAAXMSSMMSMMASAMXSAAAASAS
XSMSMSSMXAAMAXMASMXMMMMSAMXXSMSAMXAMSSSSMSMSMAAMAMMXSXMMSMASASXSXSXMAMXXSAMXMASXXASMSASMSAMAXMAAXMAMMSMSXMXSXMASXXSXMXSAMXMAMAMXSASAMXMMMSXM
XXSXXAAXSSSMSSXMMMAXMASMMMMXMAMMMMXXAMAXAAAAMMMMASAAXASAXMASASXSASASXMAMAASMSAMAMXSMSAMXMAMMMMXMSMMMAMXMAMAMAMSSXMAMMSAMXAMMMAMASAMMSASAMXAA"""

class Year2024Day4KtTest {
    @Test
    fun `part 1 - Should return correct answer based on example from advent of code`() {
        val result = countXMAS(examplePart1)
        assertEquals(18, result)
    }

    @Test
    fun `Should return correct count of line matches`(){
        val result = partialInput.lines().sumOf { countLineMatches(it) }
        assertEquals(10, result)
    }

    @Test
    fun `Should return correct count of line matches reversed`  (){
        val result = partialInput.lines().sumOf { countLineMatchesReversed(it) }
        assertEquals(15, result)
    }

    @Test
    fun `Should return a text with the columns converted to lines`(){
        val result = convertColumnsToLines("""
            123
            456
            789
        """.trimIndent())
        val expected = listOf("147", "258", "369")
        assertEquals(expected, result)
    }

    @Test
    fun `Should count occurrences of a string by columns`(){
        val result = countColumnMatches(partialInput)
        assertEquals(3, result)
    }

    @Test
    fun `Should count occurrences of a string by columns but reversed`(){
        val result = countColumnMatchesReversed(examplePart1)
        assertEquals(2, result)
    }

    @Test
    fun `Should return a list of lines with the columns on diagonal converted to lines`(){
        val result = convertColumnsOnDiagonalToLines("""
            123456
            789012
            345678
        """.trimIndent())
        val expected = listOf("3", "74","185", "296", "307","418","52", "6")
        assertEquals(expected, result)
    }

    @Test
    fun `Should return a list of lines with the columns on diagonal converted to lines but reversed`(){
        val result = convertColumnsOnDiagonalToLines("""
            123456
            789012
            345678
        """.trimIndent(), reverse = true)
        val expected = listOf("1", "27", "383", "494", "505", "616","27","8")
        assertEquals(expected, result)
    }

    @Test
    fun `Should count occurrences of a string by columns on diagonal`(){
        val result = countDiagonalMatches(examplePart1)
        assertEquals(1, result)
    }

    @Test
    fun `Should count occurrences of a string by columns on diagonal reversed`(){
        val result = countDiagonalMatchesReversed(examplePart1)
        assertEquals(1, result)
    }
}