package challenges.secondgroup

fun main() {
    while (true) {
        try {
            val l = readLine()!!.toInt()
            val v = readLine()!!.split(" ").map{it.toInt()}.sorted()

            when(v.last()) {
                in 1..9 -> println(1)
                in 10..19 -> println(2)
                else -> println(3)
            }
        } catch (e : Exception) { break }
    }
}
