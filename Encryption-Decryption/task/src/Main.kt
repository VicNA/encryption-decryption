package encryptdecrypt

fun main() {
    val operation = readln()
    val msg = readln()
    val key = readln().toInt()

    val output = if (operation == "enc") encrypt(msg, key) else decrypt(msg, key)
    println(output)
}

fun decrypt(message: String, key: Int): String {
    return message.map { it.minus(key) }.joinToString("")
}

fun encrypt(message: String, key: Int): String {
    return message.map { it.plus(key) }.joinToString("")
}
