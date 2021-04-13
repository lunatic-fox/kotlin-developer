import kotlin.math.sqrt

fun main() {
    val n = readLine()!!.toInt()
    for (i in 1..n) {
        val x = readLine()!!.toDouble()
        println(isPrime(x))
    }
}
fun isPrime(n: Double): String{
    if(( n > 2.0 && n % 2.0 == 0.0 ) || n == 1.0 ) return "Not Prime"

    for(i in 3..sqrt(n).toInt()) {
        if( n % i == 0.0) return "Not Prime"
    }
    return "Prime"
}
