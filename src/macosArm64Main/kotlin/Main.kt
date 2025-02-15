import shared.downloadInput

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        val day = args[0].toInt()
        downloadInput(day)
    } else {
        println("Número do dia não informado")
    }
}