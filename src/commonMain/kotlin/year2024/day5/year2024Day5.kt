package year2024.day5

fun sumMiddlePages(input: String): Int {
    val (classificationStr, updatesStr) = input.split("\n\n")
    val classification = classificationStr
        .lines()
        .map { line->
            val (first, second) = line.split("|")
            first.trim().toInt() .. second.trim().toInt()
        }

    print(classification)
    return 0
}