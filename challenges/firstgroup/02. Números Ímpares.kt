package challenges.firstgroup

fun main() {
    val r = readLine()?.toInt() ?: 0
    for (i in 1..r step(2)) println(i)
}
