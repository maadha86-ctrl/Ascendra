package com.ascendra.ai.domain.progress
data class UserProgress(val totalXP:Int,val vault:Int,val streak:Int,val level:Int,val mastery:Map<String,Float>)
class ProgressEngine {
    fun getProgress():UserProgress = UserProgress(24800,24800,7,7,mapOf("Business Comm" to 0.68f))
    fun addXP(current:UserProgress,xp:Int):UserProgress = current.copy(totalXP=current.totalXP+xp,vault=current.vault+xp)
}
