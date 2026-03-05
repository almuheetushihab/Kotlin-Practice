package DayFive

// Day 5: Inheritance & Abstract Classes
abstract class MobileApp(val platform: String) {
    abstract fun buildUI()
}

class AndroidApp : MobileApp("Android") {
    override fun buildUI() {
        println("Building UI with Jetpack Compose")
    }

    fun buildUITest() {
        println("Building UI with Jetpack Compose Test")
    }
}

fun main() {
    val myApp = AndroidApp()
    myApp.buildUI()
    myApp.buildUITest()
}