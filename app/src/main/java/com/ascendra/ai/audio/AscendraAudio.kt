package com.ascendra.ai.audio
import android.content.Context
import android.media.MediaPlayer
import android.util.Log
object AscendraAudio {
    private var player:MediaPlayer?=null
    fun playMotif(context:Context,type:MotifType=MotifType.OPENING){
        try{
            val resId = context.resources.getIdentifier(when(type){MotifType.OPENING->"ascendra_theme";MotifType.SUCCESS->"ascendra_success";MotifType.XP->"ascendra_xp";MotifType.FAIL->"ascendra_fail"},"raw",context.packageName)
            if(resId==0){Log.w("AscendraAudio","Raw ${type} missing - VFX only mode");return}
            player?.release(); player=MediaPlayer.create(context,resId).apply{setVolume(0.7f,0.7f);start()}
        }catch(e:Exception){Log.e("AscendraAudio","${e.message}")}
    }
    fun stop(){player?.apply{stop();release()};player=null}
    enum class MotifType{OPENING,SUCCESS,XP,FAIL}
}
