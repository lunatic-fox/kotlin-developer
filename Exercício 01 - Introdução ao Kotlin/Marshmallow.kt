import kotlin.math.pow

//////////////// Altere o código aqui ///////////////////
fun main() {
    val n1 = 1f
    val n2 = 2f
    val select = 1
    println(calculate(n1,n2,select))
}
//////////////// Altere o código aqui ///////////////////

fun calculate(a:Float?,b:Float?,s:Int?):String{
    val result:Float
    val op:String
    when{
        a==null -> {
            op="\nNão foi possível calcular!\n"+
            """Valor de "n1" é do tipo nulo!"""
        }
        b==null -> {
            op="\nNão foi possível calcular!\n"+
            """Valor de "n2" é do tipo nulo!"""
        }
        s==null -> {
            op="\nNão foi possível calcular!\n"+
            """Valor de "select" é do tipo nulo!"""
        }
        s==1 -> {
            result=a+b
            op="\n$a + $b = $result"
        }
        s==2 -> {
            result=a-b
            op="\n$a - $b = $result"
        }
        s==3 -> {
            result=a*b
            op="\n$a × $b = $result"
        }
        s==4 -> {
            result=a/b
            val remainder: Float = a%b
            op="\n$a ÷ $b = $result\n" +
                    "Resto: $remainder"
        }
        s==5 -> {
            var factorial=1
            for(i in 1..a.toInt()) factorial*=i
            op="\n${String.format("%.0f",a)}! = $factorial"
        }
        s==6 -> {
            result=a.pow(b)
            op="\n$a ^ $b = $result"
        }
        s==7 -> {
            result=(a/100)*b
            op="\n$a% de $b = ${String.format("%.2f",result)}"
        }
        else ->{op="\nOpção inválida!"}
    }
    return op
}
