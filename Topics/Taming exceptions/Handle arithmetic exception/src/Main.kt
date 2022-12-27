fun main() {
    val (a, b) = Array(2) { readln().toInt() }
    println(
        if (b == 0)
            "Division by zero, please fix the second argument!"
        else a / b
    )
}