package com.ascendra.ai.domain.quiz
data class Question(val id:String,val text:String,val options:List<String>,val correct:Int,val concept:String)
class QuizEngine {
    fun generateAdaptive(mastery:Float,concept:String):List<Question> = List(10){i->Question("Q$i","Q$i for $concept: Business Comm concept ${i+1}? - Adaptive difficulty ${if(mastery<0.6) "easy" else "hard"}",listOf("A","B","C","D"),i%4,concept)}
    fun score(answers:Map<String,Int>,questions:List<Question>):Float = answers.count{it.value==questions.find{q->q.id==it.key}?.correct}.toFloat()/questions.size
}
