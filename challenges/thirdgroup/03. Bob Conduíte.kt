package challenges.thirdgroup

fun main() {
    val r = readLine()?.toInt() ?: 0
    for (i in 1..r) {
        val x = readLine()?.split("""\s""".toRegex()) ?: listOf("0","0")
        println(x[0].toInt() + x[1].toInt())
    }
}
