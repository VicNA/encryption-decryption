fun main() {
    val list = readln().split(" ")
    var string = ""

    for (str in list) {
        if (str.length > string.length) string = str
    }

    println(string)
}