fun main() {
    var arr = intArrayOf()

    for (str in readln().chunked(3)) {
        arr += str.sumOf { it.digitToInt() }
    }

    println(if (arr[0] == arr[1]) "Lucky" else "Regular")
}