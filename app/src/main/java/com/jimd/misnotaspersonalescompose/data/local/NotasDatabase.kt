package com.jimd.misnotaspersonalescompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NotasEntity::class], version = 1, exportSchema = false)
abstract class NotasDatabase:RoomDatabase() {
    abstract fun notasDao(): NotasDao
}