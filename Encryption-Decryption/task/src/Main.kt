package encryptdecrypt

fun main() {
    val list = ('a'..'z').toList()

    val string = readln()
    val offset = readln().toInt()

    var char: Char
    for (ch in string) {
        char = if (ch.isLetter())
            list[list.lastIndex + list.indexOf(ch) + offset - list.lastIndex - 1]
        else
            ch
        print(char)
    }
}