package year2024.day1

import java.io.File

internal fun parseTextToLists(input: String): Pair<List<String>, List<String>> {
    val leftList = emptyList<String>().toMutableList()
    val rightList = emptyList<String>().toMutableList()
    input.split("\n").map { line ->
        val (left, right) = line.split("   ")
        leftList.add(left)
        rightList.add(right)
    }
    return Pair(leftList, rightList)
}

fun calcTotalDistance(lists: Pair<List<String>, List<String>>): Int {
    val (leftList, rightList) = lists
    val sortedLeftList = leftList.sorted()
    val sortedRightList = rightList.sorted()
    var sum = 0
    for (i in sortedLeftList.indices) {
        var diff: Int
        val left = sortedLeftList[i].toInt()
        val right = sortedRightList[i].toInt()
        diff = if (left > right) {
            left - right
        } else {
            right - left
        }
        sum += diff
    }
    return sum
}



fun calculateSimilarity(input: String): Int {
    return 0
}

fun main() {
    val input = File("src/main/kotlin/year2024/day1/input.txt").readText()
    val lists = parseTextToLists(input)
    println(calcTotalDistance(lists))
}