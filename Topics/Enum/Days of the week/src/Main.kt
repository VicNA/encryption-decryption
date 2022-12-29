enum class DaysOfTheWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

fun main() {
    println(DaysOfTheWeek.values().joinToString("\n"))
}