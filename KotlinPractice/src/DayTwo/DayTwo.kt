package DayTwo

//Lamda Function
val welcomeMessage = {
        name: String -> "Welcome to Day 2 of Kotlin $name"
}

fun performCalculation(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(x, y)
    return result
    println("The result is: $result")
}




fun main() {
    println(welcomeMessage("Almuheetu Shihab"))

    performCalculation(5, 3) { a, b -> a + b }
    performCalculation(5, 3) { a, b -> a - b }
}