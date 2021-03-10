package everiskotlindeveloper.bootcamp.classes

//In this class we're about to learn how to use the concept of arrays.
//So let's see...

fun main() {
    val values = IntArray(5)

    values[0] = 50
    values[1] = 20
    values[2] = 99
    values[3] = 58
    values[4] = 74

    for(i in values){ println(i) }
    // "i" gonna have the value inside "values" for each iteration, then it'll be printed.

    println("*************************")

    values.forEach {println(it)}
    // This do the same as the last for(), but it's a lambda expression.
    // "it" means kinda like -> for each time you passed in "values" print the correspondent value inside it.

    println("*************************")

    for(i in values.indices){
        //i = index number    values[i] = What's the value inside that index number!
        var ord = ""
        when{
            i == 0 -> ord = "st"
            i == 1 -> ord = "nd"
            i == 2 -> ord = "rd"
            i >= 3 -> ord = "st"
        }
        println("${i+1}$ord position: ${values[i]}")
    }

    println("*************************")

    values.sort()
    // The sort() method rearrange the values in crescent order.
    for(i in values){ println(i) }
}