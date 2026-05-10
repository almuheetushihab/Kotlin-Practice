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
    val processingFee = when(paymentMethod){
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
    for (i in 1..5 step 2){
        println("Items count : $i")
    }

    val cartItems = listOf("Laptop", "Mouse", "Keyboard")
    for (item in cartItems){
        println("Adding $item to cart")
    }

}
