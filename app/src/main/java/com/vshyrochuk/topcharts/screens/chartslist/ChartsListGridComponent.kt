package com.vshyrochuk.topcharts.screens.chartslist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.vshyrochuk.topcharts.domain.model.ChartEntity

@Composable
fun ChartsListGridComponent(
    charts: List<ChartEntity>,
    state: LazyGridState,
    onChartClick: (ChartEntity) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        state = state
    ) {
        items(charts.count(), key = {
            charts[it].remoteId
        }) { position ->
            ChartItemCard(charts[position], onChartClick)
        }
    }
}
