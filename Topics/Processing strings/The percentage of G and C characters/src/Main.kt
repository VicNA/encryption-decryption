fun main() {
    val input = readln()
    val gc = input.count { it.equals('g', true) || it.equals('c', true) }
    println(gc.toDouble() / input.length * 100)
}