package extensionFunPractice

import jdk.jfr.internal.tool.View

// Extension Function
// Extension Function কেন ব্যবহার করি?
// Class modify না করে clean way তে feature add করা যায়

// 1. [ধরো, একটা class আছে — তুমি সেটা change করতে পারছো না (library class বা built-in),
// কিন্তু তুমি চাইছো ওই class-এর উপর নতুন একটা function ব্যবহার করতে। তখন তুমি extension function ব্যবহার করো।]

// 2. Scope Functions (Extension)
//এইগুলো extremely important
// let, apply ,run , also ,with

fun String.addWelcome(): String = "Welcome to $this"

fun Int.isEven(): Boolean {
    return this % 2 == 0
}

//fun View.show(){
//    this.visibility = View.VISIBLE
//}

fun String.makeLowerCase(): String {
    return this.lowercase()
}

fun String.makeUpperCase(): String {
    return this.uppercase()
}

fun String.isEmailValid(): Boolean {
    return this.contains("@") && this.contains(".")
}

fun String.toIntOrDefault(default: Int = 0): Int {
    return this.toIntOrNull() ?: default
}

fun main() {
    val name = "Shihab"
    val age = 24
    val country = "bangladesh"
    val uppercase = country.makeUpperCase()
    val email = "almuheetu@gmail.com"

    println(email.isEmailValid())
    println(uppercase)
    println(uppercase.makeLowerCase())
    println(name.addWelcome())
    println(age.isEven())
    println("Name: $name, Age: $age")
}