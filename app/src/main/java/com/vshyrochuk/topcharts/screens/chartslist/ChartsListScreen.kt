package com.vshyrochuk.topcharts.screens.chartslist

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.vshyrochuk.topcharts.domain.model.ChartEntity

@Composable
fun ChartsListScreen(
    viewModel: ChartsListViewModel = hiltViewModel(),
    onChartClick: (ChartEntity) -> Unit
) {
    val state by viewModel.state.collectAsState(initial = ChartListUIState.Initial)
    LaunchedEffect(state == ChartListUIState.Initial) {
        viewModel.load()
    }
    val isRefreshing by viewModel.isRefreshing.collectAsState()

    return SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        onRefresh = { viewModel.refresh() },
        indicator = { indicatorState, trigger ->
            SwipeRefreshIndicator(
                // Pass the SwipeRefreshState + trigger through
                state = indicatorState,
                refreshTriggerDistance = trigger,
                // Enable the scale animation
                scale = true,
                // Change the color and shape
                contentColor = Color.Black,
                shape = MaterialTheme.shapes.medium,
            )
        }) {
        ChartsListContent(state, onRetryClicked = {
            viewModel.load()
        }, onChartClick = onChartClick)
    }
}

