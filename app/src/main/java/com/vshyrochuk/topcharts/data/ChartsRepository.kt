package com.vshyrochuk.topcharts.data

import com.vshyrochuk.topcharts.data.db.RealmChartEntity
import com.vshyrochuk.topcharts.data.db.toRealmChartEntity
import com.vshyrochuk.topcharts.domain.domain.ChartsDataSource
import com.vshyrochuk.topcharts.domain.model.ChartEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import javax.inject.Inject

class ChartsRepository @Inject constructor (
    private val localSource: ChartsDataSource,
    private val remoteSource: ChartsDataSource,
    private val realm: Realm
) {
    var entities: List<ChartEntity> = mutableListOf()
    private set

    suspend fun loadLocal(): List<ChartEntity> {
        val localCharts = localSource.load()
        entities = localCharts
        return localCharts
    }

    suspend fun loadRemote(): List<ChartEntity> {
        val remoteData =  remoteSource.load()
        entities = remoteData
        return  remoteData
    }

    suspend fun saveCharts(entities: List<ChartEntity>) {
        realm.write {
            // Remove previous data before store new
            val query = this.query<RealmChartEntity>().find()
            delete(query)
            entities.forEach { entity ->
                val realmEntity = entity.toRealmChartEntity()
                copyToRealm(realmEntity)
            }
        }
    }
}