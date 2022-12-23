fun main() {
    val list = MutableList(readln().toInt()) { readln().toInt() }
    var count = 0
    for (i in 2..list.lastIndex) {
        if (list[i] - 1 == list[i - 1] && list[i - 1] - 1 == list[i - 2]) count++
    }
    println(count)
}