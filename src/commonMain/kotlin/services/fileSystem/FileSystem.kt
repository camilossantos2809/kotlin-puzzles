package services.fileSystem

import okio.FileSystem
import okio.Path.Companion.toPath

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