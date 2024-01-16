package com.jimd.misnotaspersonalescompose.di

import com.jimd.misnotaspersonalescompose.data.NotasRepositoryImpl
import com.jimd.misnotaspersonalescompose.data.domain.NotasRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepository(repositoryImpl: NotasRepositoryImpl):NotasRepository

}