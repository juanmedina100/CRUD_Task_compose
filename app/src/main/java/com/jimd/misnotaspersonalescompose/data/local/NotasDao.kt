package com.jimd.misnotaspersonalescompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotasDao {

    @Insert
    suspend fun insertNotas(notasEntity: NotasEntity)

    @Query("select * from notasentity order by id")
    fun getAllNotas():Flow<List<NotasEntity>>

    @Query("select * from notasentity where id=:id")
    suspend fun getNotasForId(id:Int): NotasEntity

    @Update
    suspend fun updateNotas(notasEntity: NotasEntity)

    @Delete
    suspend fun deleteNota(notasEntity: NotasEntity)
}