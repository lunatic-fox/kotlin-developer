package challenges.secondgroup

fun main() {
    fun Float.format(digits: Int) = "%.${digits}f".format(this).replace(',','.')
    val r = readLine()!!.toFloat()
    var i = 0f

    when{
        r <= 2000f -> i = 0f
        r in 2000.01f..3000f -> i = (r - 2000f ) * 0.08f
        r in 3000.01f..4500f -> i = 80f + ( r - 3000f ) * 0.18f
        r > 4500f -> i = 350f + ( r - 4500f ) * 0.28f
    }

    if (i == 0f) println("Isento") else println("R$ ${i.format(2)}")
}