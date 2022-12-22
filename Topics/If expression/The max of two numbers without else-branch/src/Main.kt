fun main() {

    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()

    var max = b
    if (a > b) max = a

    println(max)
}