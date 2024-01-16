package com.jimd.misnotaspersonalescompose.Utils

import com.jimd.misnotaspersonalescompose.data.local.NotasEntity

sealed class NotasEvents{
    data class idViene(val id:Int):NotasEvents()
    data class tituloChanged(val titulo:String):NotasEvents()
    data class notasChanged(val nota:String):NotasEvents()
    data class listaDeNotas(val listaNotas:List<NotasEntity>):NotasEvents()
    object updateNota:NotasEvents()
    object deletenota:NotasEvents()
    object loading:NotasEvents()
}
