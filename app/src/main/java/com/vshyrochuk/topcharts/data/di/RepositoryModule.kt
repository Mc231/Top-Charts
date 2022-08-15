package com.vshyrochuk.topcharts.data.di

import com.vshyrochuk.topcharts.data.ChartsRepository
import com.vshyrochuk.topcharts.data.datasource.ChartsLocalDataSource
import com.vshyrochuk.topcharts.data.datasource.ChartsRemoteDataSource
import com.vshyrochuk.topcharts.data.network.ChartsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm

@Module
@InstallIn(ViewModelComponent::class, SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(api: ChartsApi, realm: Realm): ChartsRepository {
        return ChartsRepository(ChartsLocalDataSource(realm), ChartsRemoteDataSource(api), realm)
    }
}
