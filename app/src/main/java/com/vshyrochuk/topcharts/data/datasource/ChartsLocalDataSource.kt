package com.vshyrochuk.topcharts.data.datasource

import com.vshyrochuk.topcharts.data.db.RealmChartEntity
import com.vshyrochuk.topcharts.data.db.mapper.toDomain
import com.vshyrochuk.topcharts.domain.domain.ChartsDataSource
import com.vshyrochuk.topcharts.domain.model.ChartEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class ChartsLocalDataSource(private val realm: Realm) : ChartsDataSource {
    override suspend fun load(): List<ChartEntity> {
        return suspendCancellableCoroutine {
            try {
                val charts =
                    realm.query<RealmChartEntity>().find().map { chart -> chart.toDomain() }
                it.resume(charts)
            } catch (e: Exception) {
                it.resumeWithException(e)
            }
        }
    }
}