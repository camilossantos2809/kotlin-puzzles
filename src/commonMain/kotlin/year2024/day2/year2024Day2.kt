package year2024.day2


import kotlin.math.abs

fun String.splitToInt(): List<Int> = this.split(" ").map { it.toInt() }

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
    return input.count {
        isSafeReport(it.splitToInt())
    }
}

fun countSafeReportsRemovingOneLevel(input: List<String>): Int {
    return input.count { line ->
        val intList = line.splitToInt()
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
    val input = FileHelper.readLines("src/main/kotlin/year2024/day2/input.txt")
    println(countTotalSafeReports(input))
    println(countSafeReportsRemovingOneLevel(input))
}
