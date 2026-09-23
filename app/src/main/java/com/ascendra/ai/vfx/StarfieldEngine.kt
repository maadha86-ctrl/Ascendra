package com.ascendra.ai.vfx
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlin.random.Random
data class Star(var x:Float,var y:Float,var a:Float,var s:Float,var sp:Float)
@Composable fun StarfieldVFX(m:Modifier=Modifier,c:Int=180){
    var stars by remember{mutableStateOf(List(c){Star(Random.nextFloat(),Random.nextFloat(),Random.nextFloat()*0.8f+0.2f,Random.nextFloat()*2f+0.5f,Random.nextFloat()*0.3f+0.1f)})}
    LaunchedEffect(Unit){while(true){stars=stars.map{it.copy(y=(it.y+it.sp*0.001f)%1f,a=(it.a+Random.nextFloat()*0.02f-0.01f).coerceIn(0.2f,1f))};delay(32)}}
    Canvas(m.fillMaxSize()){stars.forEach{drawCircle(Color.White.copy(it.a),it.s,androidx.compose.ui.geometry.Offset(it.x*size.width,it.y*size.height))}}
}
