package com.ascendra.ai.data.local
// Lightweight in-memory DB - Room version will be added later for offline persistence
// Keeping 216MB target, no extra 3MB Room dependency in debug
data class SyllabusEntity(val id:String,val name:String,val type:String,val parentId:String?)
data class ProgressEntity(val conceptId:String,val mastery:Float,val xp:Int,val streak:Int)

interface SyllabusDao {
    suspend fun getAll():List<SyllabusEntity>
    suspend fun insertAll(list:List<SyllabusEntity>)
}

interface ProgressDao {
    suspend fun getAll():List<ProgressEntity>
    suspend fun upsert(p:ProgressEntity)
}

class InMemorySyllabusDao: SyllabusDao {
    private val data = mutableListOf<SyllabusEntity>()
    override suspend fun getAll():List<SyllabusEntity> = data
    override suspend fun insertAll(list:List<SyllabusEntity>) { data.clear(); data.addAll(list) }
}

class InMemoryProgressDao: ProgressDao {
    private val data = mutableListOf<ProgressEntity>()
    override suspend fun getAll():List<ProgressEntity> = data
    override suspend fun upsert(p:ProgressEntity) { data.removeAll{it.conceptId==p.conceptId}; data.add(p) }
}

class AscendraDatabase {
    fun syllabusDao():SyllabusDao = InMemorySyllabusDao()
    fun progressDao():ProgressDao = InMemoryProgressDao()
    companion object {
        fun getInstance():AscendraDatabase = AscendraDatabase()
    }
}
