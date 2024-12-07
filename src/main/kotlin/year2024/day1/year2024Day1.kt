package year2024.day1

import parseTextToLists
import kotlin.io.path.Path
import kotlin.io.path.readLines


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


fun calculateSimilarity(lists: Pair<List<String>, List<String>>): Int {
    val (leftList, rightList) = lists
//    implementar primeiro busca sequencial para ver se o resultado ficará correto, depois tentar fazer cache com busca indexada
    return leftList.fold(0) { acc, left ->
        left.toInt() * rightList.count { it.contains(left) } + acc
    }
}

fun main() {
    val input = Path("src/main/kotlin/year2024/day1/input.txt").readLines()
    val lists = parseTextToLists(input)
    println(calcTotalDistance(lists))
    println(calculateSimilarity(lists))
}