package kotlinLanguageFoundation

import java.io.StringReader

val name = "Shihab"
val experiance = 3

// Function
// সাধারণ ফাংশন
fun add(a: Int, b: Int): Int {
    return a + b
}

// Single-expression function (প্রফেশনালরা এভাবেই লেখে)
fun multiply(a: Int, b: Int) = a * b

fun main() {
    val birthYear = 2000
    var currentAge = 24
    currentAge = 26

    val price: Double = 99.99
    val intPrice: Int = price.toInt()
    val company: String = "Softzino"
    //Operator & ControlFLow
    val cartTotal = 1500.0
    val hasVipCard = true

    val stock = 1
    println("I am $name and I have $experiance years of experience, and my birth year is $birthYear")
    println("I work at ${company.uppercase()} and my age is $currentAge")
    println("price : $price")
    println("intPrice : $intPrice")


    //Operator & ControlFLow
    val isEligibleForDiscount = (cartTotal > 1000.0) && hasVipCard
    println("Discount Eligible for : $isEligibleForDiscount")
    val stockStatus = if (stock > 0) "In Stock" else "Out of Stock"
    println(stockStatus)

    //When expression
    val paymentMethod = "CARD"
    val processingFee = when (paymentMethod) {
        "CASH" -> 0.0
        "BKASH", "NAGAD" -> 15.0
        "CARD" -> 25.0
        else -> {
            println("Unknown Method")
            0.0
        }
    }
    println("Processing Fee: $processingFee")

    // Loops and Ranges

    //Ranges loop
    for (i in 1..5 step 2) {
        println("Items count : $i")
    }

    val cartItems = listOf("Laptop", "Mouse", "Keyboard")
    for (item in cartItems) {
        println("Adding $item to cart")
    }
// Null Safety
    // Safe call Operator
    val name: String? = null
    println(name?.length)

    // Elvis Operator
    val myName: String? = null
    val finalName = myName ?: "Guest"
    println("Final Name: $finalName")

    //Not-null Assertion (!!)
    val lastName: String? = "Shihab"
    println("Last Name Length: ${lastName!!.length}")

    //Safe Cast (as?) and Smart Cast
    val obj: Any? = "Hello"
    val str: String? = "obj"
    if (obj is String) {
        println("Safe Cast as?: ${obj.length} ____str $str")
    }
    //Function

}
