package DayOne
// Extension Function
fun Int.isEvan(): Boolean = this % 2 == 0

fun String.logAsError() {
    println("Error: $this")
}
data class Student(var name: String = "", var id: String = "")

fun main(){
    val student = Student().apply {
        name = "Shihab"
        id = "WUB03/25/71/4989"
    }

    student.let {
        println("Processing Student: ${it.name}")
        println("Processing Student: ${it.id}")
    }

    val result = "Task Completed".also {
        println("Internal Log:it" )
    }
}