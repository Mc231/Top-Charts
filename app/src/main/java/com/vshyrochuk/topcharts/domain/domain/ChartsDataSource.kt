package com.vshyrochuk.topcharts.domain.domain

import com.vshyrochuk.topcharts.domain.model.ChartEntity

interface ChartsDataSource {
    suspend fun load(): List<ChartEntity>
}