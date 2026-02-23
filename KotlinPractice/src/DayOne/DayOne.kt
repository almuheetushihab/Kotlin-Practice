package DayOne

// Extension Function
fun Int.isEvan(): Boolean = this % 2 == 0

// Extension Function
fun String.logAsError() {
    println("Error is Extension Function: $this")
}

// Extension Function
fun String.logAsSuccess() {
    println("Success is Extension Function: $this")
}


fun Int.logAsSuccessRate() {
    println("Success is Extension Function: $this")
}

//
data class Student(
    var name: String = "",
    var age: Int = 23,
    var id: String = "",
    var grade: String = "",
    var section: String = "",
    var gender: String = "",
    var address: String = "",
    var phoneNumber: String = "",
    var email: String = "",
    var nationality: String = "",
    var religion: String = "",
)

fun main() {
    val student = Student().apply {
        name = "Almuheetu Shihab"
        id = "WUB03/25/71/4989"
        age = 23
        grade = "A+"
        section = "B"
        gender = "Male"
        address = "Dhaka"
        phoneNumber = "01789803342"
        email = "almuheetu@gmail.com"
        nationality = "Bangladeshi"
        religion = "Islam"
    }

    student.let {
        println("Processing Student: ${it.name}")
        println("Processing Student: ${it.id}")
        println("Processing Student: ${it.age}")
        println("Processing Student: ${it.grade}")
    }

    student.address.logAsError()
    student.name.logAsSuccess()
    student.age.isEvan()
    student.age.logAsSuccessRate()
    println("Student Address logAsError: ${student.address.logAsError()}")

    val result = "Task Completed".also {
        println("Internal Log: $it")
    }

    println("Result : $result")

    println("\n--- 10 More Students for School Management System ---\n")

    val studentList = listOf(
        Student(
            "Rahim Mia", 14,
            "S-101",
            "8", "A",
            "Male",
            "Mirpur, Dhaka",
            "01700000001",
            "rahim@email.com",
            "Bangladeshi",
            "Islam"
        ),
        Student(
            "Fatima Begum", 13,
            "S-102",
            "7", "B",
            "Female",
            "Dhanmondi, Dhaka",
            "01700000002",
            "fatima@email.com",
            "Bangladeshi",
            "Islam"
        )
    )

    studentList.forEach { s ->
        println(
            "Student Name: ${s.name}," +
                    " Age: ${s.age}," +
                    " ID: ${s.id}," +
                    " Grade: ${s.grade}," +
                    " Section: ${s.section}"
        )
    }
}
