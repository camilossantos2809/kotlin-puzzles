import okio.FileSystem
import okio.Path.Companion.toPath

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


object FileHelper {
    fun readLines(path: String): List<String> {
        val filePath = path.toPath()
        return FileSystem.SYSTEM.read(filePath) {
            generateSequence { readUtf8Line() }.toList()
        }
    }

    fun readText(path: String): String {
        val filePath = path.toPath()
        return FileSystem.SYSTEM.read(filePath) {
            readUtf8()
        }
    }

    fun overwriteText(path: String, text: String) {
        val filePath = path.toPath()
        val fileSystem = FileSystem.SYSTEM

        if (fileSystem.exists(filePath)) {
            fileSystem.delete(filePath)
        }

        fileSystem.write(filePath) {
            writeUtf8(text)
        }
    }
}