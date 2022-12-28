fun main() {
    val params = readln().substringAfter('?').split("&")
    var pass = ""
    for (pair in params) {
        if (pair[pair.lastIndex] == '=') {
            println(pair.replace("=", " : not found"))
        } else {
            println(pair.replace("=", " : "))
        }
        if (pair.contains("pass=")) pass = pair.replace("pass=", "password : ")
    }
    if (pass.isNotEmpty()) println(pass)
}