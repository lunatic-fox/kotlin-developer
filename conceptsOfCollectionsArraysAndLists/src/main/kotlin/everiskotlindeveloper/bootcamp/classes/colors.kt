package everiskotlindeveloper.bootcamp.classes

const val RC = "\u001b[0m"
const val B = "\u001b[1m"
const val I = "\u001b[3m"
const val U = "\u001b[4m"
const val R = "\u001b[7m"
const val S = "\u001b[9m"

fun fg(n:Int) = "\u001b[38;5;${n}m"
fun bg(n:Int) = "\u001b[48;5;${n}m"

fun colorTest(){
    for(i in 0..9){print("\u001b[38;5;${i}m■$i   ")}
    for(i in 10..19){print("\u001b[38;5;${i}m■$i  ")};println("")
    for(i in 20..39){print("\u001b[38;5;${i}m■$i  ")};println("")
    for(i in 40..59){print("\u001b[38;5;${i}m■$i  ")};println("")
    for(i in 60..79){print("\u001b[38;5;${i}m■$i  ")};println("")
    for(i in 80..99){print("\u001b[38;5;${i}m■$i  ")};println("")
    for(i in 100..119){print("\u001b[38;5;${i}m■$i ")};println("")
    for(i in 120..139){print("\u001b[38;5;${i}m■$i ")};println("")
    for(i in 140..159){print("\u001b[38;5;${i}m■$i ")};println("")
    for(i in 160..179){print("\u001b[38;5;${i}m■$i ")};println("")
    for(i in 180..199){print("\u001b[38;5;${i}m■$i ")};println("")
    for(i in 200..219){print("\u001b[38;5;${i}m■$i ")};println("")
    for(i in 220..239){print("\u001b[38;5;${i}m■$i ")};println("")
    for(i in 240..255){print("\u001b[38;5;${i}m■$i ")}
}