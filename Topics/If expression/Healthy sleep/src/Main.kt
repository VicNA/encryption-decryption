fun main() {
    val (a, b, h) = List(3) { readln().toInt() }

    println(
        if (h in a..b) {
            "Normal"
        } else if (h < a) {
            "Deficiency"
        } else "Excess"
    )
}