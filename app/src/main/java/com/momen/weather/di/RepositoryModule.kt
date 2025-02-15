package com.momen.weather.di

import com.momen.data.local.LocalDataSource
import com.momen.data.remote.WeatherApi
import com.momen.data.repository.WeatherRepository
import com.momen.data.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideWeatherRepository(
        api: com.momen.data.remote.WeatherApi,
        localDataSource: com.momen.data.local.LocalDataSource
    ): com.momen.data.repository.WeatherRepository =
        com.momen.data.repository.WeatherRepositoryImpl(api, localDataSource)
}
