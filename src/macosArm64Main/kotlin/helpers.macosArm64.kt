import kotlinx.cinterop.*
import platform.posix.*

actual object FileHelper {

    @OptIn(ExperimentalForeignApi::class)
    actual fun readLines(path: String): List<String> {
        val file = fopen(path, "r") ?: throw IllegalArgumentException("File not found: $path")
        val lines = mutableListOf<String>()

        try {
            memScoped {
                val buffer = ByteArray(8192)
                while (true) {
                    val line = fgets(buffer.refTo(0), buffer.size, file)?.toKString() ?: break
                    lines.add(line.trimEnd('\n', '\r'))
                }
            }
        } finally {
            fclose(file)
        }

        return lines
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun readText(path: String): String {
        val file = fopen(path, "r") ?: throw IllegalArgumentException("File not found: $path")
        val stringBuilder = StringBuilder()

        try {
            memScoped {
                val buffer = ByteArray(8192)
                while (true) {
                    val bytesRead = fread(buffer.refTo(0), 1.convert(), buffer.size.convert(), file).toInt()
                    if (bytesRead == 0) break
                    stringBuilder.append(buffer.decodeToString(0, bytesRead))
                }
            }
        } finally {
            fclose(file)
        }

        return stringBuilder.toString()
    }
}
