fun main() {
    val input = readln()
    val map = mutableMapOf<Char, Int>()
    for (ch in input) {
        map.put(ch, map.getOrDefault(ch, 0) + 1)
    }
    println(map.filter { it.value == 1 }.size)
}