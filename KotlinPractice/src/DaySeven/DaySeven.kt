package DaySeven

// Day 7: Collections & Practical Implementation

// Focus: Lists, Maps and filtering data.

//📝 ১. থিওরি নোট
//Immutable vs Mutable: কটলিনে listOf() (পরিবর্তন করা যায় না) এবং mutableListOf() (অ্যাড/রিমুভ করা যায়) এর পার্থক্য বোঝা জরুরি।
//
//Functional Operators: filter, map, find ব্যবহার করে লিস্টের ডেটা ম্যানিপুলেট করা।

fun main() {
    val tasks = mutableListOf("Learn Kotlin", "Setup Notion", "Practice OOP")
    tasks.add("Day 7 Completed")

    val longTasks = tasks.filter { it.length > 10 }

    println("All Tasks: $tasks")
    println("Long Tasks: $longTasks")
}