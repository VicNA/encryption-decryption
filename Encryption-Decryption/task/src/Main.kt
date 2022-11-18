package encryptdecrypt

fun main() {
    val array1 = "abcdefghijklmnopqrstuvwxyz".toCharArray()
    val array2 = array1.reversedArray()

    "we found a treasure!".forEach {
        print(if (array1.contains(it)) array2[array1.indexOf(it)] else it)
    }
}