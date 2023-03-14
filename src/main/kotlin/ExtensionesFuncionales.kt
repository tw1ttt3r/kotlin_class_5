fun main() {
    // filter
    val calificaciones = listOf(10, 9 , 7, 6, 4 ,5, 10, 10, 9, 8, 8)

    // it es por defecto el nombre del item dentro del filter
    var aprobados = calificaciones.filter { it > 5 }

    // la convencion es que el primer parametro de la desestrucuración son los elementos
    // que cumplen la condición, el segundo son los que no cumplen
    val ( notasAprobadas, notasReprobadas ) = calificaciones.partition { it > 5 }

    println(aprobados)
    println(notasAprobadas)
    println(notasReprobadas)

    val numbersMap = mapOf<String, Int>(
        "Maria" to 8,
        "Pedro" to 10,
        "Andres" to 7,
        "Juan" to 6,
        "Antonio" to 6,
        "Mario" to 5,
    )

    val porNombre = numbersMap.filter { ( key, value ) -> value > 5 }

    println(porNombre)


    val preciosLibres = setOf(1024.0, 2048.5, 8224.33)

    // map
    val preciosNetos = preciosLibres.map { it * 1.16 }

    println(preciosNetos)


    val calificaciones2 = listOf<Int>(10,8, 9 ,5,3,2,5,1,7,6,9,4,10,3,6,2,6,5)

    val promedio = calificaciones2.average()

    val noReprobados = !calificaciones2.filter { it < 4 } .none()

    val extraPoints = calificaciones2.map { if (it < 10) (it + 1) else it  }

    println(" promedio $promedio ")
    println(" noReprobados $noReprobados ")
    println(" extraPoints $extraPoints ")


}