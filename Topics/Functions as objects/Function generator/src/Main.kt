fun generate(functionName: String): (Int) -> Int {
    return when (functionName) {
        "identity" -> { n -> n }
        "half" -> { n -> n / 2 }
        else -> { _ -> 0 }
    }
}