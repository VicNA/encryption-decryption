package encryptdecrypt

import java.io.File

enum class ArgumentKey(val arg: String) {
    MODE("-mode"),
    KEY("-key"),
    DATA("-data"),
    IN("-in"),
    OUT("-out"),
    ALG("-alg"),
    UNKNOWN("unknown");

    companion object {
        private val values = values()
        val argKeys = values.map { it.arg }
        fun find(arg: String) = values.find { arg == it.arg } ?: UNKNOWN
    }
}

fun main(args: Array<String>) {
    val mapArgs = mutableMapOf<ArgumentKey, String>()

//    var mode = "enc"
//    var key = 0
//    var data = ""
//    var input = ""
//    var out = ""
//    var alg = ""
    var arg = ""

    for (str in args) {
        if (str in ArgumentKey.argKeys) {
            arg = str
        } else {
            mapArgs.put(ArgumentKey.find(arg), str)
        }
    }

//    val output = if (mode == "enc") encrypt(data, key) else decrypt(data, key)
    val output = convert(mapArgs)

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

fun getMessage(args: Map<ArgumentKey, String>): String {
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
    val key = args.getValue(ArgumentKey.KEY).toInt().let { if (args.getValue(ArgumentKey.MODE) == "enc") it else -it }
    return getMessage(args).map { it + key }.joinToString("")
}

//fun decrypt(message: String, key: Int, alg: String): String {
//    return message.map { it.minus(key) }.joinToString("")
//}
//
//fun encrypt(message: String, key: Int, alg: String): String {
//    return message.map { it.plus(key) }.joinToString("")
}
