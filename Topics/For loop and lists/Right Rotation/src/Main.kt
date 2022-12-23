fun main() {
    val size = readln().toInt()
    val list = Array(size) { readln().toInt() }
    val rotate = readln().toInt() % list.size

    var num: Int
    repeat(rotate) {
        num = list.last()
        for (i in list.lastIndex - 1 downTo 0) {
            list[i + 1] = list[i]
        }
        list[0] = num
    }

    println(list.joinToString(" "))
}