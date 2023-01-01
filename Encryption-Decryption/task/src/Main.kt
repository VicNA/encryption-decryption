package encryptdecrypt

import java.io.File

fun main(args: Array<String>) {
    var mode = "enc"
    var key = 0
    var data = ""
    var input = ""
    var out = ""
    var arg = ""

    for (i in args.indices) {
        if (args[i] in listOf("-mode", "-key", "-data", "-in", "-out")) {
            arg = args[i]
        } else {
            when (arg) {
                "-mode" -> mode = args[i]
                "-key" -> key = args[i].toInt()
                "-data" -> data = args[i]
                "-in" -> input = args[i]
                "-out" -> out = args[i]
            }
        }
    }

    if (data.isEmpty() && input.isNotEmpty()) {
        try {
            data = File(input).readText()
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    val output = if (mode == "enc") encrypt(data, key) else decrypt(data, key)

    if (out.isEmpty())
        println(output)
    else {
        try {
            File(out).writeText(output)
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }
}

fun decrypt(message: String, key: Int): String {
    return message.map { it.minus(key) }.joinToString("")
}

fun encrypt(message: String, key: Int): String {
    return message.map { it.plus(key) }.joinToString("")
}
