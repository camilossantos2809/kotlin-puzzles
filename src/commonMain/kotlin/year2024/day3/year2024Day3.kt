package year2024.day3

fun extractMulValues(text: String): List<String> {
    val regex = Regex("mul\\([0-9]+,[0-9]+\\)")
    val matches = regex.findAll(text)
    return matches.map { it.value }.toList()
}

// remove all text between 'don't()' and 'do()' before extracting mul values
fun extractedFilteredMulValues(text: String): List<String> {
    val regex = Regex("don't\\(\\).*?do\\(\\)")
    val filteredText = text.replace(regex, "")
    return extractMulValues(filteredText)
}

fun calcMulValue(mulValue: String): Long {
    val (first, second) = mulValue.replace("mul(", "").replace(")", "").split(",")
    return first.toLong() * second.toLong()
}

fun sumAllMulValues(text: String): Long = extractMulValues(text).sumOf { calcMulValue(it) }

fun sumAllMulValuesFiltered(text: String): Long = extractedFilteredMulValues(text).sumOf { calcMulValue(it) }