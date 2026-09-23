package com.ascendra.ai.domain.syllabus
data class SyllabusNode(val id:String,val name:String,val type:NodeType,val children:List<SyllabusNode> = emptyList())
enum class NodeType { COUNTRY, BOARD, PROGRAM, YEAR, SUBJECT, UNIT, CHAPTER, TOPIC, CONCEPT }
object SyllabusEngine {
    fun getTree(): SyllabusNode = SyllabusNode("IN","India",NodeType.COUNTRY,listOf(
        SyllabusNode("CBSE","CBSE",NodeType.BOARD,listOf(
            SyllabusNode("BBA","BBA",NodeType.PROGRAM,listOf(
                SyllabusNode("S1","Sem1",NodeType.YEAR,listOf(
                    SyllabusNode("BC","Business Comm",NodeType.SUBJECT,listOf(
                        SyllabusNode("U1","Unit1",NodeType.UNIT,listOf(
                            SyllabusNode("C1","Chapter1",NodeType.CHAPTER)
                        ))
                    ))
                ))
            ))
        ))
    ))
}
