package com.vshyrochuk.topcharts.screens.chartslist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vshyrochuk.topcharts.domain.model.ChartEntity
import com.vshyrochuk.topcharts.screens.common.ErrorComponent
import com.vshyrochuk.topcharts.screens.common.LoadingComponent
import com.vshyrochuk.topcharts.ui.theme.TopChartsTheme

@Composable
fun ChartsListContent(
    state: ChartListUIState,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onRetryClicked: () -> Unit,
    onChartClick: (ChartEntity) -> Unit
) {
    val gridState = rememberLazyGridState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            val scrollOffset by remember(false) {
                derivedStateOf { gridState.firstVisibleItemScrollOffset == 0 }
            }
            ChartsListAppBar(scrollOffset)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
        ) {
            when (state) {
                is ChartListUIState.Error -> ErrorComponent(
                    message = state.message,
                    onRetryClicked
                )
                is ChartListUIState.ChartsLoaded -> ChartsListGridComponent(
                    charts = state.charts,
                    state = gridState,
                    onChartClick
                )
                ChartListUIState.Loading, ChartListUIState.Initial -> LoadingComponent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChartsListContentPreview() {
    TopChartsTheme {
        ChartsListContent(ChartListUIState.Loading, onChartClick = {}, onRetryClicked = {})
    }
}
