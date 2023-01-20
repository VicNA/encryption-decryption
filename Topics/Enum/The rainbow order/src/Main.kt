enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;
}

fun main() {
    val color = readln()
    Rainbow.values().forEach {
        if (it.name.equals(color, true))
            println(it.ordinal + 1)
    }
}