package DayFour

// Classes, Constructors & Properties
class Developer(val name: String, var language: String) {
    init {
        println("New developer profile created for $name")
    }
}

fun main(){
    val developer = Developer("Almuheetu Shihab", "Kotlin")
    println("${developer.name} uses ${developer.language}")
}