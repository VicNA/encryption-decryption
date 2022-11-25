package encryptdecrypt

fun main() {
    val list = ('a'..'z').toList()

    val string = readln()
    val offset = readln().toInt()

    string.forEach {
        print(if (it.isLetter()) list[(list.indexOf(it) + offset) % list.size] else it)
    }
}