package year2024.day1

import parseTextToLists
import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.math.abs


fun calcTotalDistance(lists: Pair<List<String>, List<String>>): Int {
    val (leftList, rightList) = lists
    return leftList.sorted().zip(rightList.sorted()).sumOf { (left, right) ->
        abs(left.toInt() - right.toInt())
    }
}

fun calculateSimilarity(lists: Pair<List<String>, List<String>>): Int {
    val (leftList, rightList) = lists
//    implementar primeiro busca sequencial para ver se o resultado ficará correto, depois tentar fazer cache com busca indexada
    return leftList.sumOf {  left ->
        left.toInt() * rightList.count { it.contains(left) }
    }
}

fun main() {
    val input = Path("src/main/kotlin/year2024/day1/input.txt").readLines()
    val lists = parseTextToLists(input)
    println(calcTotalDistance(lists))
    println(calculateSimilarity(lists))
}