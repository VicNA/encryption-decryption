package encryptdecrypt

import java.io.File

fun main(args: Array<String>) {
    val keyArgs = listOf("-mode", "-key", "-data", "-in", "-out", "-alg")
    val map = mutableMapOf<String, String>()

//    var mode = "enc"
//    var key = 0
//    var data = ""
//    var input = ""
//    var out = ""
    var arg = ""


    for (str in args) {
        if (str in keyArgs) {
            arg = str
        } else {
            map.put(arg, str)
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

fun readData(message: String, file: String): String {
    if (message.isEmpty() && file.isNotEmpty())
        try {
            return File(file).readText()
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    return message
}

fun decrypt(message: String, key: Int, alg: String): String {
    return message.map { it.minus(key) }.joinToString("")
}

fun encrypt(message: String, key: Int, alg: String): String {
    return message.map { it.plus(key) }.joinToString("")
}
