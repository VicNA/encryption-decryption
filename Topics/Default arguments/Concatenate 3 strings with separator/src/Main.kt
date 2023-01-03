// complete this function
fun concatenate(s1: String, s2: String, s3: String, separator: String = " "): String {
    return arrayOf(s1, s2, s3).joinToString(separator)
}