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
            mapArgs[ArgumentKey.valueOf(arg)] = str
        }
    }

    val data = getData(mapArgs)
    val key = getKey(mapArgs)

    val output = if (mapArgs.getValue(ArgumentKey.ALG) == "shift")
        shift(data, key)
    else
        unicode(data, key)

    if (!mapArgs.containsKey(ArgumentKey.OUT))
        println(output)
    else {
        try {
            File(mapArgs.getValue(ArgumentKey.OUT)).writeText(output)
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }
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

fun shift(msg: String, key: Int): String {
    return msg.map {
        if (it.isLetter()) {
            var ch = it + key
            if (it.isUpperCase()) {
                if (ch > 'Z') 'A' + (key - ('Z' - it + 1))
                else if (ch < 'A') 'Z' + (key + (it + 1 - 'A'))
                else ch
            } else {
                if (ch > 'z') 'a' + (key - ('z' - it + 1))
                else if (ch < 'a') 'z' + (key + (it + 1 - 'a'))
                else ch
            }
        } else it
    }.joinToString("")
}

fun unicode(msg: String, key: Int): String {
    return msg.map { it + key }.joinToString("")
}