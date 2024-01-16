package com.jimd.misnotaspersonalescompose.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.misnotaspersonalescompose.Utils.NotasEvents
import com.jimd.misnotaspersonalescompose.data.domain.NotasRepository
import com.jimd.misnotaspersonalescompose.data.local.NotasEntity
import com.jimd.misnotaspersonalescompose.data.local.NotasUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotasHomeViewModel @Inject constructor(
    private val repository: NotasRepository
) : ViewModel() {

    fun insertNotas(notasEntity: NotasEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNotas(notasEntity)
        }
    }

    fun getAllNotasFull() {
        viewModelScope.launch {
            repository.getAllNotas().collect {
                notasInUpdateUI = notasInUpdateUI.copy(
                    listaNotas = it
                )
            }
        }
    }

    var notaUpdate by mutableStateOf(NotasEntity(0, "", ""))
        private set

    fun getNotasForId(id: Int) {
        viewModelScope.launch {
            val myNotaUpdated = repository.getNotasForId(id)
            notaUpdate = myNotaUpdated
            notasInUpdateUI = notasInUpdateUI.copy(
                id = id,
                titulo = myNotaUpdated.titulo,
                nota = myNotaUpdated.nota
            )
        }
    }

    fun updateNotas() {
        viewModelScope.launch {
            repository.updateNotas(
                NotasEntity(notasInUpdateUI.id, notasInUpdateUI.titulo, notasInUpdateUI.nota)
            )
        }
    }

    var notasInUpdateUI by mutableStateOf(NotasUI())
    fun onEventUpdate(notasEvents: NotasEvents) {
        when (notasEvents) {
            NotasEvents.loading -> {}
            is NotasEvents.notasChanged -> {
                notasInUpdateUI = notasInUpdateUI.copy(
                    nota = notasEvents.nota
                )
            }

            is NotasEvents.tituloChanged -> {
                notasInUpdateUI = notasInUpdateUI.copy(
                    titulo = notasEvents.titulo
                )
            }

            NotasEvents.updateNota -> {
                updateNotas()
            }

            is NotasEvents.idViene -> {
                notasInUpdateUI = notasInUpdateUI.copy(
                    id = notasEvents.id
                )
            }

            NotasEvents.deletenota -> {
            }

            is NotasEvents.listaDeNotas -> {
                notasInUpdateUI = notasInUpdateUI.copy(
                    listaNotas = notasEvents.listaNotas
                )
            }
        }
    }

    fun deleteNota(notasEntity: NotasEntity) {
        viewModelScope.launch {
            repository.deleteNota(notasEntity)
        }
    }
}