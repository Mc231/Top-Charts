package com.vshyrochuk.topcharts.data.di

import com.vshyrochuk.topcharts.BuildConfig
import com.vshyrochuk.topcharts.data.network.ChartsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideChartsApi(retrofit: Retrofit): ChartsApi {
        return retrofit.create(ChartsApi::class.java)
    }
}
