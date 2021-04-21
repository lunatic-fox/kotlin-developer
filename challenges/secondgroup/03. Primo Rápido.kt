package challenges.secondgroup

fun main() {
    val n = readLine()?.toInt() ?: 0
    for (i in 1..n) {
        val x = readLine()?.toDouble() ?: 0.0
        println(isPrime(x))
    }
}

fun isPrime(n: Double): String{
    if( n == 1.0 ) {
        return "Not Prime"
    }
    var i = 2.0
    while (i * i <= n) {
        if (n % i == 0.0) {
            return "Not Prime"
        }
        i++
    }
    return "Prime"
}
