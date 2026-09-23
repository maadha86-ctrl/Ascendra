package com.ascendra.ai.ui.theme
import android.app.Activity
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
private val DarkScheme = darkColorScheme(
    primary = AscendraColors.Blue, onPrimary = AscendraColors.TextPrimary,
    background = AscendraColors.VoidDeep, onBackground = AscendraColors.TextPrimary,
    surface = AscendraColors.Panel1, onSurface = AscendraColors.TextPrimary,
    surfaceVariant = AscendraColors.PanelGlass, outline = AscendraColors.Border, scrim = AscendraColors.Scrim
)
@Composable fun AscendraTheme(content:@Composable ()->Unit){
    val view = LocalView.current
    if(!view.isInEditMode){ SideEffect{ val win=(view.context as Activity).window; win.statusBarColor=AscendraColors.VoidDeep.toArgb(); win.navigationBarColor=AscendraColors.VoidDeep.toArgb(); WindowCompat.getInsetsController(win,view).isAppearanceLightStatusBars=false } }
    MaterialTheme(colorScheme=DarkScheme, typography=AscendraTypography, content=content)
}
