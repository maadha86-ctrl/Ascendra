package com.ascendra.ai
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ascendra.ai.ui.components.AscendraIconBox
import com.ascendra.ai.ui.components.AscendraIcons
import com.ascendra.ai.ui.screens.*
import com.ascendra.ai.ui.theme.AscendraColors
import com.ascendra.ai.ui.theme.AscendraTheme
import com.ascendra.ai.vfx.StarfieldVFX

class MainActivity : ComponentActivity() {
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        setContent {
            AscendraTheme {
                var screen by remember { mutableStateOf("SPLASH") }
                var navIdx by remember { mutableStateOf(0) }
                Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(AscendraColors.VoidDeep, AscendraColors.Void)))) {
                    StarfieldVFX()
                    Box(Modifier.align(Alignment.BottomCenter).fillMaxWidth().height(140.dp).background(Brush.verticalGradient(listOf(Color.Transparent, AscendraColors.EarthGlow.copy(0.45f), AscendraColors.EarthGlow.copy(0.15f))))){}
                    when (screen) {
                        "SPLASH" -> SplashScreen { screen = "LOGIN" }
                        "LOGIN" -> LoginScreen { screen = "HOME" }
                        "HOME" -> HomeScreen()
                        "AI" -> AITutorScreen()
                        "COURSES" -> GenericThemedScreen("Courses", "Syllabus: India CBSE BBA Sem1 - 6 Units")
                        "PRACTICE" -> GenericThemedScreen("Practice", "Adaptive Engine - 68% mastery - Next: Ch 3.2")
                        "EXAMS" -> ExamsScreen()
                        "GAMES" -> GamesScreen()
                        "SPEAK" -> SpeakScreen()
                        "PROGRESS" -> GenericThemedScreen("Progress", "Ascension XP 75% - Level 7 - 24.8K Vault - 7 day streak")
                        "PROFILE" -> GenericThemedScreen("Profile", "MADHA - Level 7 Ascender - Bangalore - 82% ENERGY")
                        "SETTINGS" -> GenericThemedScreen("Settings", "Theme: Cosmic Luxury - VFX+SFX ON")
                        "VAULT" -> GenericThemedScreen("Vault", "24.8K coins - PULSE 1.2k - ENERGY 82%")
                        "LEADERBOARD" -> GenericThemedScreen("Leaderboard", "Global Rank #42 - India #7")
                        "COMMUNITY" -> GenericThemedScreen("Community", "Ascendra Guild - 3 active quests")
                        "NOTIFICATIONS" -> GenericThemedScreen("Notifications", "3 new - Nebula Sync 73% complete")
                        else -> HomeScreen()
                    }
                    if (screen != "SPLASH" && screen != "LOGIN") {
                        val items = listOf("HOME" to AscendraIcons.Home, "ADAPTIVE" to AscendraIcons.AI, "MOCKTEST" to AscendraIcons.Exams, "SCORES" to AscendraIcons.Progress, "PROFILE" to AscendraIcons.Profile)
                        Row(Modifier.align(Alignment.BottomCenter).fillMaxWidth().padding(12.dp).background(AscendraColors.VoidDeep.copy(0.85f)), horizontalArrangement = Arrangement.SpaceEvenly) {
                            items.forEachIndexed { idx, (label, icon) ->
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    IconButton(onClick = { navIdx = idx; screen = when (idx) { 0 -> "HOME"; 1 -> "AI"; 2 -> "EXAMS"; 3 -> "PROGRESS"; 4 -> "PROFILE"; else -> "HOME" } }) {
                                        AscendraIconBox(icon, isActive = navIdx == idx)
                                    }
                                    Text(label, style = MaterialTheme.typography.labelSmall, color = if (navIdx == idx) AscendraColors.GoldGlow else AscendraColors.TextTertiary)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
