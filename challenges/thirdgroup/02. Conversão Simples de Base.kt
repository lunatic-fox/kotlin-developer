package challenges.thirdgroup

fun main() {
    var s: String
    var n: Int
    val r = """0x.*""".toRegex()

    while (true){
        var input = readLine()!!

        if(input.matches(r)){
            input = input.removePrefix("0x")
            n = Integer.parseInt(input, 16)
            println(n)
        } else if (input.toInt() >= 0){
            s = Integer.toHexString(input.toInt()).toUpperCase()
            s = "0x$s"
            println(s)
        } else { break }
    }
}