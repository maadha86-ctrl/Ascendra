package com.ascendra.ai.domain.syllabus
object GlobalSyllabusEngine {
    data class UniversityPattern(val theory:Int, val internal:Int, val types:List<String>)
    val universities = mapOf(
        "SMU" to UniversityPattern(70, 30, listOf("MCQ", "Short 5m", "Long 10m")),
        "VTU" to UniversityPattern(100, 0, listOf("MCQ", "Short", "Long")),
        "MU" to UniversityPattern(80, 20, listOf("MCQ", "Short", "Long")),
        "DU" to UniversityPattern(75, 25, listOf("MCQ", "Short", "Long")),
        "MIT" to UniversityPattern(100, 0, listOf("Problem Set", "Project")),
        "STANFORD" to UniversityPattern(100, 0, listOf("Assignment", "Midterm")),
        "OXFORD" to UniversityPattern(100, 0, listOf("Essay", "Tutorial")),
        "CUSTOM" to UniversityPattern(70, 30, listOf("MCQ", "Short", "Long"))
    )
    fun detectPattern(uniId:String): UniversityPattern {
        return universities[uniId.uppercase()] ?: universities["CUSTOM"]!!
    }
}
