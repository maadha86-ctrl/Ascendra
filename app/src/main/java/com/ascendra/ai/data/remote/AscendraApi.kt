package com.ascendra.ai.data.remote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONObject

object AscendraApi {
    var BASE_URL = "https://alias-constitute-smith-glasses.trycloudflare.com"
    
    suspend fun getUniversities():String = withContext(Dispatchers.IO){
        try{ URL("$BASE_URL/api/universities").readText() }catch(e:Exception){ "Offline: 8 universities - SMU,VTU,MU,DU,MIT,Stanford,Oxford,CUSTOM" }
    }
    suspend fun getSyllabus(uniId:String, program:String, year:String):String = withContext(Dispatchers.IO){
        try{ URL("$BASE_URL/api/syllabus/$uniId/$program/$year").readText() }catch(e:Exception){ "Offline syllabus $uniId - Using local GLOBAL engine" }
    }
    suspend fun ask(query:String, subject:String, uniId:String="SMU"):String = askAITutor(query, subject, uniId)
    
    suspend fun askAITutor(query:String, subject:String, uniId:String="SMU"):String = withContext(Dispatchers.IO){
        try{
            val url = URL("$BASE_URL/api/ai/tutor")
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod="POST"
            conn.setRequestProperty("Content-Type","application/json")
            conn.doOutput=true
            conn.connectTimeout=10000
            conn.readTimeout=10000
            val body = JSONObject().apply{put("query",query);put("subject",subject);put("universityId",uniId)}.toString()
            conn.outputStream.write(body.toByteArray())
            val res = conn.inputStream.bufferedReader().readText()
            conn.disconnect()
            JSONObject(res).optString("response","Ascendra GLOBAL AI [$uniId $subject]: $query - 100% prep")
        }catch(e:Exception){ "GLOBAL AI [$uniId $subject]: $query - Adapted for 100% result [LIVE $BASE_URL] Offline mode: PYQ+Important+Marking" }
    }
}
