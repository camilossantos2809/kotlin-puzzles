package shared

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.runBlocking
import services.http.Api
import services.fileSystem.FileHelper

fun downloadInput(day: Int) {
    runBlocking(Dispatchers.IO) {
        val input = Api.getInputByDay(day)
        FileHelper.overwriteText("./inputs/input-$day.txt", input)
    }
}
