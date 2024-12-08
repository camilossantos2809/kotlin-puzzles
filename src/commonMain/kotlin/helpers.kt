 fun parseTextToLists(input: List<String>): Pair<List<String>, List<String>> {
    val leftList = emptyList<String>().toMutableList()
    val rightList = emptyList<String>().toMutableList()
    input.map { line ->
        val (left, right) = line.split("   ")
        leftList.add(left)
        rightList.add(right)
    }
    return Pair(leftList, rightList)
}


 expect object FileHelper {
     fun readLines(path: String): List<String>
     fun readText(path:String):String
 }