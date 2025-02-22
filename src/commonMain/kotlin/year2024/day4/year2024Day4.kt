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
    for (col in 0 until columnSize) {
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

fun countDiagonalMatches(text: String): Int {
    val columns = convertColumnsOnDiagonalToLines(text)
    return columns.sumOf { countLineMatches(it) }
}

fun countDiagonalMatchesReversed(text: String): Int {
    val columns = convertColumnsOnDiagonalToLines(text, reverse = true)
    println(columns)
    return columns.sumOf { countLineMatches(it) }
}

fun countXMAS(text: String): Int {
    val lines = text.lines()
    val results = lines.map { listOf(countLineMatches(it)) }
    return 0
}

