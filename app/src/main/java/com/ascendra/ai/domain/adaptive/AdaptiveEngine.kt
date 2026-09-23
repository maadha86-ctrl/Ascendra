package com.ascendra.ai.domain.adaptive
data class LearnerState(val mastery:Map<String,Float>,val streak:Int,val xp:Int)
class AdaptiveEngine {
    fun nextConcept(current:String,perf:Float,state:LearnerState):String = if(perf<0.6f)"remedial_$current" else "next_$current"
    fun calcXP(correct:Boolean,time:Int):Int = if(correct)(100-time).coerceAtLeast(10) else 5
}
