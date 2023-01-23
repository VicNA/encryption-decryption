import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    Array(5) { scanner.next() }.forEach { println(it) }
}