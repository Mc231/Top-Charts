package com.vshyrochuk.topcharts.screens.chartpreview

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.UriHandler
import com.vshyrochuk.topcharts.screens.common.ErrorComponent
import com.vshyrochuk.topcharts.screens.common.LoadingComponent

@Composable
fun ChartPreviewContainer(
    state: ChartPreviewUIState,
    viewModel: ChartPreviewViewModel,
    uriHandler: UriHandler,
    dateFormatter: ReleaseDateFormatter,
    entityId: String?,
    onBackClicked: () -> Unit
) {
    when (state) {
        is ChartPreviewUIState.Error -> ErrorComponent(message = state.message) {
            viewModel.load(entityId)
        }
        is ChartPreviewUIState.ChartLoaded -> ChartPreviewContent(
            entity = state.entity,
            onBackClicked,
            dateFormatter,
            uriHandler
        )
        ChartPreviewUIState.Loading, ChartPreviewUIState.Initial -> LoadingComponent()
    }
}
