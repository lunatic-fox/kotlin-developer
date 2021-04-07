package challenges.secondgroup

fun main() {
    fun Float.format(digits: Int) = "%.${digits}f".format(this).replace(',','.')

    val i = when (val r = readLine()!!.toFloat()) {
        in 0f..2000f -> 0f
        in 2000.01f..3000f -> (r - 2000f ) * 0.08f
        in 3000.01f..4500f -> 80f + ( r - 3000f ) * 0.18f
        else -> 350f + ( r - 4500f ) * 0.28f
    }

    if (i == 0f) println("Isento") else println("R$ ${i.format(2)}")
}
