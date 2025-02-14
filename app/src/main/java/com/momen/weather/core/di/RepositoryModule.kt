package com.momen.weather.core.di

import com.momen.weather.data.local.LocalDataSource
import com.momen.weather.data.remote.WeatherApi
import com.momen.weather.data.repository.WeatherRepository
import com.momen.weather.data.repository.WeatherRepositoryImpl
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
        api: WeatherApi,
        localDataSource: LocalDataSource
    ): WeatherRepository = WeatherRepositoryImpl(api, localDataSource)
}
