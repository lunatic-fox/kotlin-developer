package challenges.firstgroup

fun main() {
    var r = 1
    for (i in 1..readLine()!!.toInt()) {
        println("$r ${r*i} ${r*i*i}")
        r++
    }
}