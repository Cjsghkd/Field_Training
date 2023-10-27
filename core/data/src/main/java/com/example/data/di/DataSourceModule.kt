package com.example.data.di

import com.example.data.datasource.DallaMainDataSource
import com.example.data.datasource.DallaMainDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataSourceModule {
    @Binds
    fun bindsDallaMainDataSource(
        dallaDataSourceImpl: DallaMainDataSourceImpl
    ): DallaMainDataSource
}