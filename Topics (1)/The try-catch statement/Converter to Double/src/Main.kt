fun convertStringToDouble(input: String): Double {
    return try {
        input.toDouble()
    } catch (e: NumberFormatException) {
        0.0
    }
}