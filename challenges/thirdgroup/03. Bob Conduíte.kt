package challenges.thirdgroup

fun main() {
    for (i in 1..readLine()!!.toInt()) {
        val r = readLine()!!.split("""\s""".toRegex())
        println(r[0].toInt() + r[1].toInt())
    }
}
