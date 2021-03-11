package everiskotlindeveloper.bootcamp.classes

//In this class we're about to learn how to use the concept of IntArrayOf().
//So let's see...

fun main() {
    val values = intArrayOf(50,20,99,58,54)

    println("${RC}Using forEach lambda function...")
    values.forEach {print("[$it]  ")}

    values.sort()
    println("\n\n${RC}After ${fg(11)}sort$RC() method...")
    for(i in values){print("[$i]  ")}
}