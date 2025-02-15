package year2024.day3

fun extractMulValues(text: String): List<String> {
    val regex = Regex("mul\\([0-9]+,[0-9]+\\)")
    val matches = regex.findAll(text)
    return matches.map { it.value }.toList()
}

fun calcMulValue(mulValue: String): Long {
    val (first, second) = mulValue.replace("mul(", "").replace(")", "").split(",")
    return first.toLong() * second.toLong()
}

fun sumAllMulValues(text: String): Long = extractMulValues(text).sumOf { calcMulValue(it) }