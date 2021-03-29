package challenges.secondgroup

fun main(){
    while (true) {
        try {
            val l = readLine()!!.toInt()
            val v = readLine()!!.split(" ").map{it.toInt()}.sorted()

            when{
                v.last() < 10 -> println(1)
                v.last() >= 20 -> println(3)
                else -> println(2)
            }
        } catch (e : Exception){ break }
    }
}