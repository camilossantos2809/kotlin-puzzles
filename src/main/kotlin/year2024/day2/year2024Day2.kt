package year2024.day2

import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.math.abs

fun isAllIncreasing(list: List<Int>): Boolean {
    return list.zipWithNext { previous, next -> previous < next }.all { it }
}

fun isAllDecreasing(list: List<Int>): Boolean {
    return list.zipWithNext { previous, next -> previous > next }.all { it }
}

// Any two adjacent levels differ by at least one and at most three.
fun hasOnlyAllowedDiffs(list: List<Int>): Boolean {
    return list.zipWithNext { previous, next -> abs(next - previous) in 1..3 }.all { it }
}

fun countTotalSafeReports(input: List<String>): Int {
    return input.count { line ->
        val intList = line.split(" ").map { it.toInt() }
        (isAllIncreasing(intList) || isAllDecreasing(intList)) && hasOnlyAllowedDiffs(intList)
    }
}

fun main() {
    val input = Path("src/main/kotlin/year2024/day2/input.txt").readLines()
    println(countTotalSafeReports(input))
}