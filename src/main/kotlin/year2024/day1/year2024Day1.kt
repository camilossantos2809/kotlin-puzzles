package year2024.day1

import java.io.File

fun calcTotalDistance(input: String): Int {
    val leftList = emptyList<String>().toMutableList()
    val rightList = emptyList<String>().toMutableList()
    input.split("\n").map { line ->
        val (left, right) = line.split("   ")
        leftList.add(left)
        rightList.add(right)
    }
    leftList.sort()
    rightList.sort()
    var sum = 0
    for (i in leftList.indices) {
        var diff: Int
        val left = leftList[i].toInt()
        val right = rightList[i].toInt()
        diff = if (left > right) {
            left - right
        } else {
            right - left
        }
        sum += diff
    }
    return sum
}

fun main() {
    val input = File("src/main/kotlin/year2024/day1/input.txt").readText()
    println(calcTotalDistance(input))
}