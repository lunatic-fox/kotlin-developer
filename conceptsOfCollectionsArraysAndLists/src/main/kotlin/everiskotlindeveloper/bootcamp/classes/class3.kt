package everiskotlindeveloper.bootcamp.classes

fun main() {
    val names = Array(5){""}

    names[0] = "Ester"
    names[1] = "Carla"
    names[2] = "Diogo"
    names[3] = "Bruno"
    names[4] = "Alana"

    println("Using for() function...")
    for(i in names.indices){print("${colors(names[i])}\t")}
    println("\n")

    println("${RC}Using forEach lambda function...")
    names.forEach{print("${colors(it)}\t")}

    println("\n")
    names.sort()
    println("${RC}After ${fg(11)}sort$RC() method...")
    for(i in names.indices){
        print("${colors(names[i])}\t")}
}

fun colors(name:String):String{
    var x = ""
    when(name){
        "Ester" -> x = "${fg(196)}[Ester]"
        "Carla" -> x = "${fg(118)}[Carla]"
        "Diogo" -> x = "${fg(226)}[Diogo]"
        "Bruno" -> x = "${fg(13)}[Bruno]"
        "Alana" -> x = "${fg(51)}[Alana]"
    }
    return x
}
