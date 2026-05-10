package kotlinLanguageFoundation

val name = "Shihab"
val experiance = 3

fun main() {
    val birthYear = 2000
    var currentAge = 24
    currentAge = 26

    val price: Double = 99.99
    val intPrice: Int = price.toInt()
    val company: String = "Softzino"
    println("I am $name and I have $experiance years of experience, and my birth year is $birthYear")
    println("I work at ${company.uppercase()} and my age is $currentAge")
    println("price : $price")
    println("intPrice : $intPrice")
}
