# Projeto 1 - Calculadora em Kotlin :1234:

​	Olá! :star2:
​	Vamos lá!

​	Vou te explicar aqui como funciona esse pequeno projeto em Kotlin.

​	Trata-se de um exercício nessa linguagem de programação com o objetivo de criar uma calculadora simples que permite algumas operações matemáticas.

​	Ainda estou começando e qualquer ajuda a entender melhor o funcionamento dessa linguagem será mais que bem-vinda!!!



## Como funciona a calculadora?

​	Você vai precisar alterar apenas alguns valores nessa região do código

````kotlin
//////////////// Altere o código aqui ///////////////////
fun main() {
    val n1 = 10f
    val n2 = 2f
    val select = 4
    println(calculate(n1,n2,select))
}
//////////////// Altere o código aqui ///////////////////
````

​	Os valores das constantes *n1* e *n2* funcionam onde *n1* é o primeiro número a ser calculado junto de *n2* que é o segundo número.

​	Lembrando que essas constantes devem ser valores do tipo `Float` ou `null` para que sejam aceitos pela função *calculate*, portanto digite o número seguido de `f` ou `F`. Ou então, no lugar do valor digite `null` caso queira ver a mensagem de erro.

**Exemplos:**

````kotlin
val n1 = 25f    
val n1 = 48.6f
val n1 = null 
````

​	Após essa parte basta digitar o tipo de cálculo alterando o valor do *select*. Aqui abaixo segue a lista de operações que a função *calculate* pode fazer:

````kotlin
val selector = 1        --> Adição
// n1 + n2 = <resultado>

val selector = 2        --> Subtração
// n1 - n2 = <resultado>

val selector = 3        --> Multiplicação
// n1 * n2 = <resultado>

val selector = 4        --> Divisão
// n1 / n2 = <resultado>
// Resto:<resto>

val selector = 5        --> Fatorial
// n1! = <resultado>

val selector = 6        --> Exponenciação
// n1 ^ n2 = <resultado>

val selector = 7        --> Porcentagem
// n1% de n2 = <resultado>
````

###### _Obs: No caso do cálculo do fatorial considera-se apenas o valor de "n1" para cálculo, porém se "n2" for nulo a mensagem de erro aparecerá._

###### _Será considerada apenas a parte inteira de "n1", sendo ignorada qualquer casa decimal durante o cálculo._


​	Logo abaixo temos a função _calculate_.

​	Ela basicamente recebe dois valores do tipo `Float` ou do tipo `null`, sendo um valor recebido pelo argumento *a* e outro valor pelo argumento *b*, um valor do tipo`Int` ou `null` pelo argumento *s* e devolve um valor do tipo `String` que será a mensagem com o devido cálculo apresentado.

````kotlin
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
            op="\n$a ÷ $b = $result\n" + "Resto: $remainder"
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
````

​	Na função *calculate* temos a estrutura de controle `when` que possibilita criar uma série de opções com base nos valores das três constantes iniciais.

​	Dentre essas opções temos quando *a*, *b* ou *s*, que recebem valores de *n1*, *n2* e *select*, respectivamente são do tipo `null`, neste caso o valor devolvido pela função será uma mensagem de erro pré-estabelecida.

​	A função sempre irá devolver um valor do tipo `String`, portanto é crucial que tenha essa validação de nulidade dentro de alguma estrutura de controle como o `when`.

​	A mensagem dessa validação de nulidade poderia ser escrita de forma menos específica da seguinte maneira

````kotlin
when{
	a==null||b==null||s==null -> {
	op="Não foi possível calcular!"
	}
}
````

​	Onde é devolvido uma única mensagem dizendo que algum dos valores é do tipo `null`.

​	E então, tudo pronto para testar?
​	Teste o arquivo *"calculator.kt"* que está aqui e bons estudos! 

## 	:rocket::star2::star2::star2:
