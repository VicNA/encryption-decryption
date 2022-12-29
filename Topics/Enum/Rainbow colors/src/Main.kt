fun main() {
    val color = readln()
    var hasRainbow = false
    for (enum in Rainbow.values()) {
        if (enum.name == color.uppercase()) {
            hasRainbow = true
            break
        }
    }
    println(hasRainbow)
}

enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}