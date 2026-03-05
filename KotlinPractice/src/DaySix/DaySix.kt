package DaySix

// Day 6: Data Classes & Sealed Classes
//
// Focus: Modern data handling in Kotlin.
// 📝১. থিওরি নোট Data Class: শুধুমাত্র ডেটা হোল্ড করার
// জন্য। এটি অটোমেটিক toString(), equals(), এবং copy() ফাংশন জেনারেট করে। Sealed
// Class: এটি একটি "Restricted Hierarchy"। এটি মূলত When এক্সপ্রেশনের সাথে API Response হ্যান্ডেল করতে দারুণ কাজ করে
// (Success, Error, Loading)।


data class User(val id: Int, val name: String)

sealed class ScreenState {
    data object Loading : ScreenState()
    data class Success(val data: String) : ScreenState()
    data class Error(val message: String) : ScreenState()
}

fun main() {
    // Data Class Demonstration
    val user1 = User(1, "Shihab")
    val user2 = user1.copy(id = 2) // Using copy()
    println("User 1: $user1") // Using auto-generated toString()
    println("User 2: $user2")

    // Sealed Class Demonstration
    val state: ScreenState = ScreenState.Success("Data Loaded Successfully")
    
    when(state) {
        is ScreenState.Loading -> println("Loading...")
        is ScreenState.Success -> println("Success: ${state.data}")
        is ScreenState.Error -> println("Error: ${state.message}")
    }
}
