package challenges.secondgroup

fun main(){
    val lista = mutableListOf<Int>()
    for(i in 1..readLine()!!.toInt()){
        val input = readLine()!!.split(" ").map{it.toInt()}
        val number1 = input[0]
        val number2 = input[1]
        lista.add(mdc(number1,number2))
    }
    lista.forEach{println(it)}
}

fun mdc(num1:Int,num2:Int):Int{
    var n1 = num1
    var n2 = num2
    while(n1 != n2){
        if(n1 > n2) n1 -= n2 else n2 -= n1
    }
    return n1
}