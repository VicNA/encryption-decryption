fun main() {
    val ships = List(3) { readln().split(" ").map { it.toInt() } }
    val rows = mutableListOf<Int>()
    val column = mutableListOf<Int>()
    for (i in 1..5) {
        if (ships[0][0] != i && ships[1][0] != i && ships[2][0] != i) rows.add(i)
        if (ships[0][1] != i && ships[1][1] != i && ships[2][1] != i) column.add(i)
    }
    println(rows.joinToString(" "))
    println(column.joinToString(" "))
}