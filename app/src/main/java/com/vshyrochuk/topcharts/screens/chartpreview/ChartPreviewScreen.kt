package com.vshyrochuk.topcharts.screens.chartpreview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ChartPreviewScreen(
    viewModel: ChartPreviewViewModel = hiltViewModel(),
    uriHandler: UriHandler = LocalUriHandler.current,
    dateFormatter: ReleaseDateFormatter = ReleaseDateFormatter,
    entityId: String?,
    onBackClicked: () -> Unit
) {
    val state by viewModel.state.collectAsState(initial = ChartPreviewUIState.Initial)

    LaunchedEffect(state == ChartPreviewUIState.Initial) {
        viewModel.load(entityId)
    }
    ChartPreviewContainer(
        state = state,
        viewModel = viewModel,
        entityId = entityId,
        dateFormatter = dateFormatter,
        uriHandler = uriHandler,
        onBackClicked = onBackClicked
    )
}
