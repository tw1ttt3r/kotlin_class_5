fun main() {
    // lambda function
    var hola = { println("Hola Mundo") }

    hola()

    // declaración no explicita
    val sumaLambda = { a: Int, b: Int -> a + b }

    // declaración explicita
    val suma1: (Int, Int) -> Int = { a, b -> a + b }
    println(suma1(4,5))

    val presentarse: (String, Int) -> String = { name, age -> "me llamo $name y tengo $age años" }

    println(presentarse("Pedro", 32))

    // funcion lambda
    var saverGrade: (Double, Double) -> Unit = { expected, saved ->
        val percentage = saved / expected

        when {
            percentage > 1 -> "Ahorrador pro"
            percentage == 1.0 -> "Buen ahorrador"
            percentage < 1.0 && percentage >= .8 -> "Ahorrador promedio"
            else -> "Aprendiz saver"
        }
    }

    println(saverGrade(10.0, 1.0))

    // funcion anonima
    var saverGrade2 = fun (expected: Double, saved: Double): String {
        val percentage = saved / expected

        return when {
            percentage > 1 -> "Ahorrador pro"
            percentage == 1.0 -> "Buen ahorrador"
            percentage < 1.0 && percentage >= .8 -> "Ahorrador promedio"
            else -> "Aprendiz saver"
        }
    }

    // high order function
    val suma = {a: Int, b: Int -> a + b}
    val resta = {a: Int, b: Int -> a - b}
    val multi = {a: Int, b: Int -> a * b}

    fun calculadora(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
        return operacion(a, b)
    }

    // Ocupando lambdas o anonimas
    calculadora(4, 5, suma)
    // Ocupando funciones nombradas
    calculadora(8, 9, ::sumaFun)

    getPrice(1000, getPromo(1000, "HALFIVA"))
    getPrice(1000, getPromo(1000, "NOIVA"))
    getPrice(1000, getPromo(1000, "IVA"))
    getPrice(1000, getPromo(1000, "MINUS100"))
    getPrice(1000, getPromo(1000, "PROMO2023"))

}

fun sumaFun (a: Int, b: Int): Int {
    return a + b
}


enum class Discount{ NOIVA, HALFIVA, MINUS100, PROMO2023 }

fun getPromo(total: Int, cupon: String): (Int) -> Double {

    val noiva: (tot: Int) -> Double = { tot -> tot.toDouble()  }
    val halfiva: (tot: Int) -> Double = { tot -> tot * 1.08  }
    val minus100: (tot: Int) -> Double = { tot -> (tot * 1.6) / 2  }
    val promo2023: (tot: Int) -> Double = { tot -> (tot / 3).toDouble()  }


    return when(cupon) {
        "NOIVA" -> noiva
        "HALFIVA" -> halfiva
        "MINUS100" -> minus100
        "PROMO2023" -> promo2023
        else -> { a: Int -> a * 1.16 }
    }
}

fun getPrice(total: Int, promo: (Int) -> Double): Unit {
    println("El precio total es: ${promo(total)}")
}

