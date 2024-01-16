package com.jimd.misnotaspersonalescompose.data.domain

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.jimd.misnotaspersonalescompose.data.local.NotasEntity
import kotlinx.coroutines.flow.Flow

interface NotasRepository {

    suspend fun insertNotas(notasEntity: NotasEntity)

    fun getAllNotas(): Flow<List<NotasEntity>>

    suspend fun getNotasForId(id:Int): NotasEntity

    suspend fun updateNotas(notasEntity: NotasEntity)

    suspend fun deleteNota(notasEntity: NotasEntity)
}