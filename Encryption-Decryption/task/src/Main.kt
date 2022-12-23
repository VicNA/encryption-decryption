package encryptdecrypt

fun main(args: Array<String>) {
    var mode = "enc"
    var key = 0
    var data = ""
    var arg = ""

    for (i in args.indices) {
        if (args[i] in listOf("-mode", "-key", "-data")) {
            arg = args[i]
        } else {
            when (arg) {
                "-mode" -> mode = args[i]
                "-key" -> key = args[i].toInt()
                "-data" -> data = args[i]
            }
        }
    }

    val output = if (mode == "enc") encrypt(data, key) else decrypt(data, key)
    println(output)
}

fun decrypt(message: String, key: Int): String {
    return message.map { it.minus(key) }.joinToString("")
}

fun encrypt(message: String, key: Int): String {
    return message.map { it.plus(key) }.joinToString("")
}
