package com.ascendra.ai.domain.speech
data class SpeechChallenge(val id:String,val prompt:String,val target:String,val durationSec:Int=60)
class SpeechEngine {
    fun getDailyChallenge():SpeechChallenge = SpeechChallenge("D1","Introduce your business in 60s","Business Communication fluency")
    fun evaluate(transcript:String):Float = (transcript.length/100f).coerceIn(0f,1f) // stub - replace with LLM
}
