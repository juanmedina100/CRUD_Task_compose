package com.jimd.misnotaspersonalescompose.di

import android.content.Context
import androidx.room.Room
import com.jimd.misnotaspersonalescompose.Utils.Constants.Companion.DATABASE_NOTAS
import com.jimd.misnotaspersonalescompose.data.local.NotasDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotasModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context)= Room.databaseBuilder(
        context, NotasDatabase::class.java,DATABASE_NOTAS
    ).build()

    @Singleton
    @Provides
    fun provideDao(db: NotasDatabase)=db.notasDao()
}