package challenges.secondgroup

import kotlin.math.sqrt
fun main() {
    val n = readLine()!!.toInt()
    for (i in 2..n + 1) {
        val x = readLine()!!.toLong()
        println(isPrime(x))
    }
}
fun isPrime(n:Long):String{
    if(( n > 2L && n % 2L == 0L ) || n == 1L ) return "Not Prime"

    for(i in 3L..sqrt(n.toDouble()).toLong()){
        if( n % i == 0L) return "Not Prime"
    }
    return "Prime"
}