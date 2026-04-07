package extensionFunPractice

// Extension Function
// Extension Function কেন ব্যবহার করি?
// Class modify না করে clean way তে feature add করা যায়

// [ধরো, একটা class আছে — তুমি সেটা change করতে পারছো না (library class বা built-in),
// কিন্তু তুমি চাইছো ওই class-এর উপর নতুন একটা function ব্যবহার করতে। তখন তুমি extension function ব্যবহার করো।]


fun String.addWelcome(): String = "Welcome to $this"

fun Int.isEven(): Boolean {
    return this % 2 == 0
}

fun main() {
    val name = "Shihab"
    val age = 24


    println(name.addWelcome())
    println(age.isEven())
    println("Name: $name, Age: $age")
}