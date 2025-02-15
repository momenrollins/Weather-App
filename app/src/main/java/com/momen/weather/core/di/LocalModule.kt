package com.momen.weather.core.di


import android.content.Context
import com.momen.data.local.LocalDataSource
import com.momen.data.local.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideLocalDataSource(@ApplicationContext context: Context): com.momen.data.local.LocalDataSource =
        com.momen.data.local.LocalDataSourceImpl(context)
}
