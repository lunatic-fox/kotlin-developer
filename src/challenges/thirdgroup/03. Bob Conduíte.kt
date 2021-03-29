package challenges.thirdgroup

fun main() {
    val t = readLine()!!.toInt()
    val p = """\s""".toRegex()

    for (i in 1..t) {
        val rS = readLine()!!
        val r = rS.split(p)
        val r1 = r[0].toInt()
        val r2 = r[1].toInt()
        println(r1+r2)
    }
}