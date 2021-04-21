package challenges.secondgroup

fun main() {
    val list = mutableListOf<Int>()
    val r = readLine()?.toInt() ?: 0
    for(i in 1..r) {
        val input = readLine()?.split(" ")?.map{ it.toInt() } ?: listOf(-1, -1)
        val number1 = input[0]
        val number2 = input[1]
        list.add(mdc(number1,number2))
    }
    list.forEach{ println(it) }
}

fun mdc(num1: Int,num2: Int): Int {
    var n1 = num1
    var n2 = num2
    while(n1 != n2){
        if(n1 > n2) {
            n1 -= n2
        } else { n2 -= n1 }
    }
    return n1
}
