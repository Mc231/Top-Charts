package com.vshyrochuk.topcharts.data.datasource

import com.vshyrochuk.topcharts.BuildConfig
import com.vshyrochuk.topcharts.data.network.ChartsApi
import com.vshyrochuk.topcharts.data.network.mapping.toDomain
import com.vshyrochuk.topcharts.domain.domain.ChartsDataSource
import com.vshyrochuk.topcharts.domain.model.ChartEntity

class ChartsRemoteDataSource(private val api: ChartsApi) : ChartsDataSource {

    override suspend fun load(): List<ChartEntity> {
        return api.getCharts(BuildConfig.COUNTRY, BuildConfig.LOAD_LIMIT).toDomain()
    }
}