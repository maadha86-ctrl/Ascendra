package com.ascendra.ai.domain.games
data class GameState(val level:Int,val score:Int,val nebulaSync:Float,val nodesExpanded:Int)
class GamesEngine {
    fun getNebulaSyncGame():GameState = GameState(1,0,0.73f,0)
    fun updateSync(state:GameState,action:String):GameState = state.copy(nebulaSync=(state.nebulaSync+0.05f).coerceAtMost(1f),score=state.score+10)
    fun getNodeExpansionGame():GameState = GameState(2,0,0.41f,7)
}
