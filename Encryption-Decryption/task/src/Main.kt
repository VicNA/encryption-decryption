package encryptdecrypt

import java.io.File

enum class ArgumentKey(val arg: String) {
    MODE("-mode"),
    KEY("-key"),
    DATA("-data"),
    IN("-in"),
    OUT("-out"),
    ALG("-alg");

    companion object {
        private val values = values()
        val argKeys = values.map { it.arg }
    }
}

fun main(args: Array<String>) {
    val mapArgs = mutableMapOf<ArgumentKey, String>()
    var arg = ""

    for (str in args) {
        if (str in ArgumentKey.argKeys) {
            arg = str.substring(1).uppercase()
        } else {
            mapArgs.put(ArgumentKey.valueOf(arg), str)
        }
    }

    val data = getData(mapArgs)
    val key = getKey(mapArgs)
    val shift = { s: String, k: Int ->
        s.map {
            if (it.isLetter()) (it.code + k) % 'z'.minus('a') + 'a'.code
            else it
        }.joinToString("")
    }

//    val output = if (mode == "enc") encrypt(data, key) else decrypt(data, key)
//    val output = convert(mapArgs)

//    if (out.isEmpty())
//        println(output)
//    else {
//        try {
//            File(out).writeText(output)
//        } catch (e: Exception) {
//            println("Error: ${e.message}")
//        }
//    }
}

fun getKey(args: Map<ArgumentKey, String>): Int {
    return args.getOrDefault(ArgumentKey.KEY, "0").toInt().let {
        if (args.getValue(ArgumentKey.MODE) == "enc") it else -it
    }
}

fun getData(args: Map<ArgumentKey, String>): String {
    if (!args.containsKey(ArgumentKey.DATA) && args.containsKey(ArgumentKey.IN)) {
        try {
            return File(args.getValue(ArgumentKey.IN)).readText()
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    return args.getOrDefault(ArgumentKey.DATA, "")
}

fun convert(args: Map<ArgumentKey, String>): String {
    val key = args.getOrDefault(ArgumentKey.KEY, "0").toInt().let {
        if (args.getValue(ArgumentKey.MODE) == "enc") it else -it
    }

    return getData(args).map { it + key }.joinToString("")
}

//fun decrypt(message: String, key: Int, alg: String): String {
//    return message.map { it.minus(key) }.joinToString("")
//}
//
//fun encrypt(message: String, key: Int, alg: String): String {
//    return message.map { it.plus(key) }.joinToString("")
//}
