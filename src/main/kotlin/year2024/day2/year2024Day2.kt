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

fun isSafeReport(list: List<Int>) = (isAllIncreasing(list) || isAllDecreasing(list)) && hasOnlyAllowedDiffs(list)

fun countTotalSafeReports(input: List<String>): Int {
    return input.count { line ->
        val intList = line.split(" ").map { it.toInt() }
        isSafeReport(intList)
    }
}

fun countSafeReportsRemovingOneLevel(input: List<String>): Int {
    return input.count { line ->
        val intList = line.split(" ").map { it.toInt() }
        if (isSafeReport(intList)) {
            return@count true
        }
         intList.withIndex().any { (index) ->
            val filtered = intList.filterIndexed { filterIndex, _ -> filterIndex != index }
            isSafeReport(filtered)
        }
    }
}

fun main() {
    val input = Path("src/main/kotlin/year2024/day2/input.txt").readLines()
    println(countTotalSafeReports(input))
    println(countSafeReportsRemovingOneLevel(input))
}