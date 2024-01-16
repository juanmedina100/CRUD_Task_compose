package com.jimd.misnotaspersonalescompose.data.local

data class NotasUI(
    val id:Int=0,
    var titulo:String="",
    var nota:String="",
    var loading:Boolean=false,
    var listaNotas:List<NotasEntity> = emptyList()
)
