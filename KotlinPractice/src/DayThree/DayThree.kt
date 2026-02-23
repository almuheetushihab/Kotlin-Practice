package DayThree

fun main(){
    val universityName: String? = "World University Of Bangladesh"

    println("University Length: ${universityName?.length}")

    val nameToShow = universityName ?: "UnKnown University"
    println("University Name: $nameToShow")

    universityName?.let {
        println("University Name: $it")
    }

    // Demonstrating null case
    val nullableName: String? = null
    val displayName = nullableName ?: "Guest User"
    println("Display Name: $displayName")


}
