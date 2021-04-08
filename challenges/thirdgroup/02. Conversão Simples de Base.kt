package challenges.thirdgroup

fun main() {
    while (true){
        val input = readLine()!!

        if (input.matches("""0x.*""".toRegex())) {
            println( Integer.parseInt(input.removePrefix("0x"), 16) )
        } else if (input.toInt() >= 0) {
            println( "0x${Integer.toHexString(input.toInt()).toUpperCase()}" )
        } else { break }
    }
}
