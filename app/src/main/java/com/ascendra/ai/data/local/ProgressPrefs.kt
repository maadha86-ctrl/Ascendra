package com.ascendra.ai.data.local

import android.content.Context
import android.content.SharedPreferences

class ProgressPrefs(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("ascendra_progress", Context.MODE_PRIVATE)
    
    var totalXP: Int
        get() = prefs.getInt("total_xp", 120)
        set(v) = prefs.edit().putInt("total_xp", v).apply()
    
    var streak: Int
        get() = prefs.getInt("streak", 3)
        set(v) = prefs.edit().putInt("streak", v).apply()
    
    var level: Int
        get() = prefs.getInt("level", 1)
        set(v) = prefs.edit().putInt("level", v).apply()
    
    var businessCommMastery: Float
        get() = prefs.getFloat("bc_mastery", 0.68f)
        set(v) = prefs.edit().putFloat("bc_mastery", v).apply()
    
    var accountingMastery: Float
        get() = prefs.getFloat("fa_mastery", 0.40f)
        set(v) = prefs.edit().putFloat("fa_mastery", v).apply()
    
    var mathMastery: Float
        get() = prefs.getFloat("bm_mastery", 0.10f)
        set(v) = prefs.edit().putFloat("bm_mastery", v).apply()
    
    fun addXP(amount: Int) {
        totalXP += amount
        level = (totalXP / 500) + 1
    }
}
