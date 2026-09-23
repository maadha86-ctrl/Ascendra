package com.ascendra.ai.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.ascendra.ai.ui.theme.AscendraColors
@Composable fun AscendraIconBox(icon:ImageVector,modifier:Modifier=Modifier,accent:Color=AscendraColors.Blue,isActive:Boolean=false){
    Box(modifier.size(56.dp).clip(RoundedCornerShape(14.dp)).background(Brush.radialGradient(listOf(AscendraColors.Panel2,AscendraColors.Void))),contentAlignment=Alignment.Center){
        Box(Modifier.fillMaxSize().background(Brush.linearGradient(listOf(AscendraColors.Platinum.copy(0.15f),Color.Transparent)))){}
        Icon(icon,null,tint=if(isActive)AscendraColors.GoldGlow else accent.copy(0.9f),modifier=Modifier.size(26.dp))
        if(isActive) Box(Modifier.align(Alignment.BottomCenter).fillMaxWidth().height(2.dp).background(AscendraColors.GoldGlow)){}
    }
}
object AscendraIcons{
    val Home=Icons.Filled.Home;val AI=Icons.Filled.Psychology;val Courses=Icons.Filled.MenuBook
    val Practice=Icons.Filled.Quiz;val Exams=Icons.Filled.Assignment;val Games=Icons.Filled.SportsEsports
    val Speak=Icons.Filled.RecordVoiceOver;val Progress=Icons.Filled.TrendingUp;val Profile=Icons.Filled.Person
    val Settings=Icons.Filled.Settings;val Notifications=Icons.Filled.Notifications
}
