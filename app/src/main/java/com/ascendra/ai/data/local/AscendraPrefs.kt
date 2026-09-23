package com.ascendra.ai.data.local

import android.content.Context
import android.content.SharedPreferences

class AscendraPrefs(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("ascendra_prefs", Context.MODE_PRIVATE)
    
    var isOnboardingComplete: Boolean
        get() = prefs.getBoolean("onboarding_complete", false)
        set(v) = prefs.edit().putBoolean("onboarding_complete", v).apply()
    
    var country: String
        get() = prefs.getString("country", "IN") ?: "IN"
        set(v) = prefs.edit().putString("country", v).apply()
    
    var system: String
        get() = prefs.getString("system", "") ?: ""
        set(v) = prefs.edit().putString("system", v).apply()
    
    var institution: String
        get() = prefs.getString("institution", "") ?: ""
        set(v) = prefs.edit().putString("institution", v).apply()
    
    var program: String
        get() = prefs.getString("program", "") ?: ""
        set(v) = prefs.edit().putString("program", v).apply()
    
    var semester: String
        get() = prefs.getString("semester", "") ?: ""
        set(v) = prefs.edit().putString("semester", v).apply()
    
    var language: String
        get() = prefs.getString("language", "English") ?: "English"
        set(v) = prefs.edit().putString("language", v).apply()
    
    var userName: String
        get() = prefs.getString("user_name", "MADHA") ?: "MADHA"
        set(v) = prefs.edit().putString("user_name", v).apply()
}
