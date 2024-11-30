package year2023.day1

import java.io.File

val validDigitNames = mapOf(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9
)

fun calibration(input: String): Int {
    return input.split("\n").map { line ->
        val digitsFound = mutableMapOf<Int, Int>()
        validDigitNames.forEach { entry ->
            var index = line.indexOf(entry.key)
            if (index != -1) {
                digitsFound[index] = entry.value
            }
            index = line.indexOfFirst { it.isDigit() }
            if (index != -1) {
                digitsFound[index] = line[index].digitToInt()
            }
            index = line.indexOfLast { it.isDigit() }
            if (index != -1) {
                digitsFound[index] = line[index].digitToInt()
            }
        }
        val first = digitsFound.minByOrNull { it.key }?.value ?: 0
        val last = digitsFound.maxByOrNull { it.key }?.value ?: 0
        "$first$last".toInt()
    }
        .fold(0) { acc, number -> acc + number }
}


fun main() {
    val input = File("src/main/kotlin/year2023/day1/input.txt").readText()
    println(calibration(input))
}


