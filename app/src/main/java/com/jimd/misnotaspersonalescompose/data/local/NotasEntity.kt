package com.jimd.misnotaspersonalescompose.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NotasEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    var titulo:String,
    var nota:String
)
