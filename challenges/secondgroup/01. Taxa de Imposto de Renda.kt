package challenges.secondgroup

fun main() {
    fun Float.format(digits: Int) = "%.${digits}f".format(this).replace(',','.')

    when (val r = readLine()?.toFloat() ?: -1f) {
        -1f -> println("")
        in 0f..2000f -> println("Isento")
        in 2000.01f..3000f -> println("R$ ${((r - 2000f ) * 0.08f).format(2)}")
        in 3000.01f..4500f -> println("R$ ${(80f + ( r - 3000f ) * 0.18f).format(2)}")
        else -> println("R$ ${(350f + ( r - 4500f ) * 0.28f).format(2)}")
    }
}
