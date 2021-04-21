package challenges.thirdgroup

fun main() {
    val n = readLine()?.toInt() ?: 0
    for (i in 1..n) {
        val x = readLine() ?: "0A0"
        val n1 = "${x[0]}".toInt()
        val n2 = "${x[2]}".toInt()
        when{
            n1 == n2 -> println(n1*n2)
            x[1] in 'A'..'Z' -> println(n2-n1)
            else -> println(n1+n2)
        }
    }
}
