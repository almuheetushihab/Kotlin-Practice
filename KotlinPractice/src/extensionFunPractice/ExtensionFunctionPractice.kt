package extensionFunPractice

// Extension Function
fun String.addWelcome(): String = "Welcome to $this"


fun main() {
    val name = "Shihab"
    println(name.addWelcome())
}