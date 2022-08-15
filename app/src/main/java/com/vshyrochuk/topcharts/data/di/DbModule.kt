package com.vshyrochuk.topcharts.data.di

import com.vshyrochuk.topcharts.data.db.RealmChartGenreEntity
import com.vshyrochuk.topcharts.data.db.RealmChartEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun providesRealmConfig(): RealmConfiguration =
        RealmConfiguration.Builder(
            schema = setOf(
                RealmChartEntity::class,
                RealmChartGenreEntity::class
            )
        ).build()

    @Provides
    @Singleton
    fun provideRealm(configuration: RealmConfiguration): Realm = Realm.open(configuration)
}

