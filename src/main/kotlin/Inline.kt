fun main() {
    noInline { println("No Inlined") }
}

fun noInline(runLambda: () -> Unit) {
    println("antes de ejecutar lambda")
    runLambda()
    println("despues de ejecutar lambda")
}