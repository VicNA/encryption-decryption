fun main() {
    val numbers = Array(readln().toInt()) { readln().toInt() }
    val num = readln().toInt()

    println(numbers.count { it == num })
}