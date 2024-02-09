package com.jimd.misnotaspersonalescompose.data

import com.jimd.misnotaspersonalescompose.Utils.MyResource
import com.jimd.misnotaspersonalescompose.data.domain.NotasRepository
import com.jimd.misnotaspersonalescompose.data.local.NotasDao
import com.jimd.misnotaspersonalescompose.data.local.NotasEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotasRepositoryImpl @Inject constructor(
    private val dao: NotasDao
) : NotasRepository {
    override suspend fun insertNotas(notasEntity: NotasEntity) {
        dao.insertNotas(notasEntity)
    }

    override fun getAllNotas()=dao.getAllNotas()


    override suspend fun getNotasForId(id: Int): NotasEntity {
        return dao.getNotasForId(id)
    }

    override suspend fun updateNotas(notasEntity: NotasEntity) {
        dao.updateNotas(notasEntity)
    }

    override suspend fun deleteNota(notasEntity: NotasEntity) {
        dao.deleteNota(notasEntity)
    }


}