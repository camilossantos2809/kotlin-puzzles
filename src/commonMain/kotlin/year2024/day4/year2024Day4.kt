package year2024.day4

const val WORD_MATCH = "XMAS"
const val WORD_MATCH_REVERSED = "SAMX"

fun countOccurrencesOfAString(line: String, stringToFind: String): Int {
    var count = 0
    var lastMatch = 0
    do {
        val match = line.indexOf(stringToFind, lastMatch)
        if (match != -1) {
            count += 1
            lastMatch = match + stringToFind.length
        }
    } while (match > -1)
    return count
}

fun convertColumnsToLines(fullText: String): List<String> {
    val lines = fullText.lines()
    val columnSize = lines[0].length
    val lineSize = lines.size
    val columnsConverted = mutableListOf<String>()
    for (col in 0 until columnSize) {
        val columnToLine = buildString {
            for (line in 0 until lineSize) {
                append(lines[line][col])
            }
        }
        columnsConverted.add(columnToLine)
    }
    return columnsConverted
}

fun convertColumnsOnDiagonalToLines(fullText: String, reverse: Boolean = false): List<String> {
    val lines = fullText.lines()
    val columnSize = lines[0].length
    val lineSize = lines.size
    val columnsConverted = mutableListOf<String>()
    val startLoopValue = if (reverse) 0 else -(lineSize - 1)
    val endLoopValue = if (reverse) columnSize + (lineSize - 1) else columnSize
    for (col in startLoopValue until endLoopValue) {
        val columnToLine = buildString {
            for (line in 0 until lineSize) {
                lines.getOrNull(line)?.getOrNull((if (reverse) col - line else col + line))?.let { append(it) }
            }
        }
        columnsConverted.add(columnToLine)
    }
    return columnsConverted
}

fun countLineMatches(line: String): Int {
    return countOccurrencesOfAString(line, WORD_MATCH)
}

fun countLineMatchesReversed(line: String): Int {
    return countOccurrencesOfAString(line, WORD_MATCH_REVERSED)
}

fun countColumnMatches(fullText: String): Int {
    val columns = convertColumnsToLines(fullText)
    return columns.sumOf { countLineMatches(it) }
}

fun countColumnMatchesReversed(text: String): Int {
    val columns = convertColumnsToLines(text)
    return columns.sumOf { countLineMatchesReversed(it) }
}

fun countDiagonalMatches(fullText: String): Int {
    val columns = convertColumnsOnDiagonalToLines(fullText)
    return columns.sumOf { countLineMatches(it) + countLineMatchesReversed(it) }
}

fun countDiagonalMatchesReversed(text: String): Int {
    val columns = convertColumnsOnDiagonalToLines(text, reverse = true)
    return columns.sumOf { countLineMatches(it) + countLineMatchesReversed(it) }
}

fun countXMAS(text: List<String>): Int {
    val fullText = text.joinToString("\n")
    val sumLines = text.sumOf { line -> countLineMatches(line) + countLineMatchesReversed(line) }
    val sumColumns = countColumnMatches(fullText) + countColumnMatchesReversed(fullText)
    val sumDiagonal = countDiagonalMatches(fullText) + countDiagonalMatchesReversed(fullText)
    val sum =
        sumLines + sumColumns + sumDiagonal
    return sum
}

