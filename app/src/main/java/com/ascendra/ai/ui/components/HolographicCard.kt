package com.ascendra.ai.ui.components
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ascendra.ai.ui.theme.AscendraColors
@Composable fun HolographicCard(modifier:Modifier=Modifier, accent:Color=AscendraColors.BorderBlue, content:@Composable ColumnScope.()->Unit){
    Card(modifier=modifier, shape=RoundedCornerShape(18.dp), colors=CardDefaults.cardColors(containerColor=AscendraColors.PanelGlass), border=BorderStroke(1.dp, Brush.linearGradient(listOf(accent.copy(0.6f), AscendraColors.BorderPurple.copy(0.6f))))) {
        Box{ Box(Modifier.fillMaxWidth().height(1.dp).background(Brush.horizontalGradient(listOf(Color.Transparent, accent.copy(0.8f), Color.Transparent)))); Column(Modifier.padding(16.dp), content=content) }
    }
}
